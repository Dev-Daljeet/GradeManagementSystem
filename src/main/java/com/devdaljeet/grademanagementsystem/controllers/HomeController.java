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


@Controller
public class HomeController {
	
	@Autowired
	@Lazy
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome()
	{
		return "home.html";
	}
	
	@GetMapping("/list")
	public String goToAddPage(Model model)
	{
		model.addAttribute("student", new Student());
		return "add.html";
	}
	
	@GetMapping("/add")
	public String addStudent(Model model, @ModelAttribute Student student)
	{
		student.calcAverageGrade();
		da.addStudent(student);
		da.addNewUser(student.getName(), student.getStudentId());
		long userId = da.findUserAccount(student.getName()).getUserId();
		da.addUserRoles(userId, 2);
		model.addAttribute("student", new Student());
		return "add.html";
	}

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
	
	@GetMapping("/edit/{id}")
	public String goToEditPage(Model model, @PathVariable int id){
		Student student = da.getStudentById(id);
		model.addAttribute("student", student);
		return "edit.html";
	}
	
	@GetMapping("/edit")
	public String editContact(Model model, @ModelAttribute Student student)
	{
		student.calcAverageGrade();
		da.editStudent(student);
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteContact(Model model, @PathVariable int id){
		da.deleteStudent(id);
		return "redirect:/view";
	}
	
	@GetMapping("/login")
	public String goToLoginPage()
	{
		return "login.html";
	}
	
	@GetMapping("/access-denied")
	public String goToAccessDeniedPage()
	{
		return "access-denied.html";
	}
	
	@GetMapping("/register")
	public String goRegistration () {
		return "register.html";
	}
	
	@PostMapping("/register")
	public String doRegistration(@RequestParam String username,
						@RequestParam String password) {
		
		da.addNewUser(username, password);
		long userId = da.findUserAccount(username).getUserId();
		da.addUserRoles(userId, 1);		
		return "redirect:/";
	}
	
}

