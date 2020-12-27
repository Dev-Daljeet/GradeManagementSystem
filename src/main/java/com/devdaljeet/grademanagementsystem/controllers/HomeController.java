package com.devdaljeet.grademanagementsystem.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devdaljeet.grademanagementsystem.beans.Student;
import com.devdaljeet.grademanagementsystem.database.DatabaseAccess;

/** Represents a controller which has all URL mappings.
 * @author Daljeet Singh (Dev-Daljeet) 
 * @version 1.0
 */
@Controller
public class HomeController {
	
	@Autowired
	@Lazy
	private DatabaseAccess da;
	
	/** Directs to home page of application.
	 * @return A HTML page which acts as home page.
	 */
	@GetMapping("/")
	public String goHome()
	{
		return "home.html";
	}
	
	/** Directs to add page through which user [professor] can add a student.
	 * @return A HTML page which acts as add student page.
	 */
	@GetMapping("/list")
	public String goToAddPage(Model model)
	{
		model.addAttribute("student", new Student());
		return "addStudent.html";
	}
	
	/** Adds the student to the database.
	 * @return A HTML page which acts as add student page.
	 */
	@GetMapping("/add")
	public String addStudent(Model model, @ModelAttribute Student student)
	{
		student.calcAverageGrade();
		da.addStudent(student);
		da.addNewUser(student.getName(), student.getStudentId());
		long userId = da.findUserAccount(student.getName()).getUserId();
		da.addUserRoles(userId, 2);
		model.addAttribute("student", new Student());
		return "addStudent.html";
	}

	/** If user has professor role, views/returns all students with their info present in database. If user has student role, returns only that student info.
	 * @return A HTML page which acts as view student info page.
	 */
	@GetMapping("/view")
	public String viewStudent(Authentication auth, Model model)
	{
		String name = auth.getName();
		ArrayList<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga: auth.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		String htmlPage = "viewAsProf.html";
		
		for (String i: roles)
		{
			if(i.equalsIgnoreCase("ROLE_PROFESSOR"))
			{
				model.addAttribute("students",da.getStudents());
				model.addAttribute("classAverage",da.getAverageOfAllStudents());
			}
			else if(i.equalsIgnoreCase("ROLE_STUDENT"))
			{
				model.addAttribute("student",da.getStudentByName(name));
				htmlPage = "viewAsStud.html";
			}
		}
		return htmlPage;
	}
	
	/** Directs to edit student info page for editing the properties/grades of a student
	 * @return A HTML page which acts as edit student info page
	 */
	@GetMapping("/edit/{id}")
	public String goToEditPage(Model model, @PathVariable int id){
		Student student = da.getStudentById(id);
		model.addAttribute("student", student);
		return "editStudent.html";
	}
	
	/** Saves the edited properties of a student to database
	 * @return (Redirects to) A HTML page which acts as view student info page
	 */
	@GetMapping("/edit")
	public String editContact(Model model, @ModelAttribute Student student)
	{
		student.calcAverageGrade();
		da.editStudent(student);
		return "redirect:/view";
	}
	
	/** Delete the student from database
	 * @return (Redirects to) A HTML page which acts as view student info page
	 */
	@GetMapping("/delete/{id}")
	public String deleteContact(Model model, @PathVariable int id){
		da.deleteStudent(id);
		return "redirect:/view";
	}
	
	/** Directs to login page
	 * @return A HTML page which acts as login page
	 */
	@GetMapping("/login")
	public String goToLoginPage()
	{
		return "login.html";
	}
	
	/** Directs to access denied page. It happens only when user tries to access a restricted URL.
	 * @return A HTML page which acts as access denied page
	 */
	@GetMapping("/access-denied")
	public String goToAccessDeniedPage()
	{
		return "access-denied.html";
	}
	
	/** Directs to register page for registering the user as a professor
	 * @return A HTML page which acts as register user page
	 */
	@GetMapping("/register")
	public String goRegistration () {
		return "register.html";
	}
	
	/** Register/Adds the user in database with role Professor.
	 * @return (Redirects to ) A HTML page which acts as home page
	 */
	@PostMapping("/register")
	public String doRegistration(@RequestParam String username,
						@RequestParam String password) {
		
		da.addNewUser(username, password);
		long userId = da.findUserAccount(username).getUserId();
		da.addUserRoles(userId, 1);		
		return "redirect:/";
	}
	
}

