package com.devdaljeet.grademanagementsystem.database;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.devdaljeet.grademanagementsystem.beans.OverallClassAverage;
import com.devdaljeet.grademanagementsystem.beans.Student;
import com.devdaljeet.grademanagementsystem.beans.User;


/** Represents the database access class which manipulates the database
 * @author Dajeet Singh (Dev-Daljeet)
 * @version 1.0
 */
@Repository
public class DatabaseAccess {
	
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	/** Adds a student to database
	 * @param student An instance of class Student
	 */
	public void addStudent(Student student)
	{
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		String query = "INSERT INTO student (name, studentId, exercises, assignment1, assignment2, assignment3, midterm, finalExam, averageGrade, letterGrade) VALUES "
				+ "(:name, :stuId, :exercises, :assign1, :assign2, :assign3, :midterm, :finalExam, :averageGrade, :letterGrade);";
		parameters.addValue("name", student.getName());
		parameters.addValue("stuId", student.getStudentId());
		parameters.addValue("exercises", student.getExercises());
		parameters.addValue("assign1", student.getAssignment1());
		parameters.addValue("assign2", student.getAssignment2());
		parameters.addValue("assign3", student.getAssignment3());
		parameters.addValue("midterm", student.getMidterm());
		parameters.addValue("finalExam", student.getFinalExam());
		parameters.addValue("averageGrade", student.getAverageGrade());
		parameters.addValue("letterGrade", student.getLetterGrade());
		jdbc.update(query, parameters);
	}
	
	/** Returns/gets all students from database
	 * @return students An array list of all students
	 */
	public ArrayList<Student> getStudents(){
		ArrayList<Student> students = new ArrayList<>();
		String query = "SELECT * FROM student";
		List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String,Object>());
		
		for(Map<String, Object> row: rows) {
			Student student= new Student();
			student.setId((Integer)(row.get("id")));
			student.setName((String)(row.get("name")));
			student.setStudentId((String)(row.get("studentId")));
			student.setExercises(((BigDecimal)(row.get("exercises"))).doubleValue());
			student.setAssignment1(((BigDecimal)(row.get("assignment1"))).doubleValue());
			student.setAssignment2(((BigDecimal)(row.get("assignment2"))).doubleValue());
			student.setAssignment3(((BigDecimal)(row.get("assignment3"))).doubleValue());
			student.setMidterm(((BigDecimal)(row.get("midterm"))).doubleValue());
			student.setFinalExam(((BigDecimal)(row.get("finalExam"))).doubleValue());
			student.setAverageGrade(((BigDecimal)(row.get("averageGrade"))).doubleValue());
			student.setLetterGrade((String)(row.get("letterGrade")));
			students.add(student);
		}
		return students;
	}
	
	/** Returns/gets a student of specific ID from database
	 * @param id An integer which represents the ID of a student
	 * @return student An instance of class Student
	 */
	public Student getStudentById(int id) {
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		ArrayList<Student> students = new ArrayList<>();
		String query = "SELECT * FROM student WHERE ID=:id";
		parameters.addValue("id",id);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows) {
			Student student= new Student();
			student.setId((Integer)(row.get("id")));
			student.setName((String)(row.get("name")));
			student.setStudentId((String)(row.get("studentId")));
			student.setExercises(((BigDecimal)(row.get("exercises"))).doubleValue());
			student.setAssignment1(((BigDecimal)(row.get("assignment1"))).doubleValue());
			student.setAssignment2(((BigDecimal)(row.get("assignment2"))).doubleValue());
			student.setAssignment3(((BigDecimal)(row.get("assignment3"))).doubleValue());
			student.setMidterm(((BigDecimal)(row.get("midterm"))).doubleValue());
			student.setFinalExam(((BigDecimal)(row.get("finalExam"))).doubleValue());
			student.setAverageGrade(((BigDecimal)(row.get("averageGrade"))).doubleValue());
			student.setLetterGrade((String)(row.get("letterGrade")));
			students.add(student);
		}
		if(students.size()>0) {
		return students.get(0);
		}
		else {
			return null;
		}
	}
	
	/** Returns/gets a student of specific name from database
	 * @param name A String which represents the name of a student
	 * @return student An instance of class Student
	 */
	public Student getStudentByName(String name) {
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		ArrayList<Student> students = new ArrayList<>();
		String query = "SELECT * FROM student WHERE name=:name";
		parameters.addValue("name",name);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows) {
			Student student= new Student();
			student.setId((Integer)(row.get("id")));
			student.setName((String)(row.get("name")));
			student.setStudentId((String)(row.get("studentId")));
			student.setExercises(((BigDecimal)(row.get("exercises"))).doubleValue());
			student.setAssignment1(((BigDecimal)(row.get("assignment1"))).doubleValue());
			student.setAssignment2(((BigDecimal)(row.get("assignment2"))).doubleValue());
			student.setAssignment3(((BigDecimal)(row.get("assignment3"))).doubleValue());
			student.setMidterm(((BigDecimal)(row.get("midterm"))).doubleValue());
			student.setFinalExam(((BigDecimal)(row.get("finalExam"))).doubleValue());
			student.setAverageGrade(((BigDecimal)(row.get("averageGrade"))).doubleValue());
			student.setLetterGrade((String)(row.get("letterGrade")));
			students.add(student);
		}
		if(students.size()>0) {
		return students.get(0);
		}
		else {
			return null;
		}
	}
	
	/** Edits/Updates a student in database
	 * @param student An instance of class Student
	 */
	public void editStudent(Student student)
	{
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		String query = "UPDATE student SET name=:name, studentId=:stuId, exercises=:exercises, assignment1=:assign1, assignment2=:assign2, assignment3=:assign3, midterm=:midterm, finalExam=:finalExam, averageGrade=:averageGrade, letterGrade=:letterGrade WHERE id=:id";
		parameters.addValue("id", student.getId());
		parameters.addValue("name", student.getName());
		parameters.addValue("stuId", student.getStudentId());
		parameters.addValue("exercises", student.getExercises());
		parameters.addValue("assign1", student.getAssignment1());
		parameters.addValue("assign2", student.getAssignment2());
		parameters.addValue("assign3", student.getAssignment3());
		parameters.addValue("midterm", student.getMidterm());
		parameters.addValue("finalExam", student.getFinalExam());
		parameters.addValue("averageGrade", student.getAverageGrade());
		parameters.addValue("letterGrade", student.getLetterGrade());
		jdbc.update(query, parameters);
	}
	
	/** Deletes a student of specific ID from database
	 * @param id An integer which represents the ID of a student
	 */
	public void deleteStudent(int id)
	{
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		String query = "DELETE FROM student WHERE id=:id";
		parameters.addValue("id",id);
		
		jdbc.update(query, parameters);
	}

	/** Get average grade of every section of a course 
	 * @return overallClassAverage An instance of class OverallClassAverage
	 */
	public OverallClassAverage getAverageOfAllStudents(){
		ArrayList<OverallClassAverage> list = new ArrayList<OverallClassAverage>();
		String query = "SELECT AVG(exercises) AS avgExercises, AVG(assignment1) AS avgAssign1, AVG(assignment2) AS avgAssign2, AVG(assignment3) AS avgAssign3, AVG(midterm) AS avgMidterm, AVG(finalExam) AS avgFinalExam, AVG(averageGrade) AS overallAverageGrade FROM student";
		List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String,Object>());
		DecimalFormat decimalFormat = new DecimalFormat("###0.##");
	
		for(Map<String, Object> row: rows) {
			OverallClassAverage overallClassAvg = new OverallClassAverage();
			overallClassAvg.setAvgExercises(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("avgExercises"))).doubleValue())));
			overallClassAvg.setAvgAssignment1(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("avgAssign1"))).doubleValue())));
			overallClassAvg.setAvgAssignment2(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("avgAssign2"))).doubleValue())));
			overallClassAvg.setAvgAssignment3(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("avgAssign3"))).doubleValue())));
			overallClassAvg.setAvgMidterm(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("avgMidterm"))).doubleValue())));
			overallClassAvg.setAvgFinalExam(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("avgFinalExam"))).doubleValue())));
			overallClassAvg.setOverallAverageGrade(Double.parseDouble(decimalFormat.format(((BigDecimal)(row.get("overallAverageGrade"))).doubleValue())));
			list.add(overallClassAvg);
		}
		return list.get(0);
	}
	
	/** Finds the user account of a specific name
	 * @param name A String which represents the name of a user (Student/Professor)
	 * @return user An Instance of class User 
	 */
	public User findUserAccount(String userName) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user WHERE userName=:userName";
		parameters.addValue("userName",userName);
		ArrayList<User> users = (ArrayList<User>)jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));
		if(users.size()>0) 
		{
			return users.get(0);
		}
		else 
		{
			return null;
		}
	}
	
	/** Gets/Returns list of strings which represents the roles given to a user
	 * @param userId A long which represents the user ID of a user
	 * @return roles The list of strings which represents the roles given to a user
	 */
	public List<String> getRolesById(long userId) {
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select user_role.userId, sec_role.roleName "
				+ "FROM user_role, sec_role "
				+ "WHERE user_role.roleId=sec_role.roleId "
				+ "and userId=:userId";
		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			roles.add((String)row.get("roleName"));
		}
		return roles;
	}
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/** Adds a new user in the database
	 * @param username A String which represents the username of a user 
	 * @param password A String which represents the password of a user
	 */
	public void addNewUser(String username, String password) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "insert into SEC_User (userName, encryptedPassword, ENABLED) values (:user, :pass, 1);";
		parameters.addValue("user",username);
		parameters.addValue("pass", passwordEncoder.encode(password));
		jdbc.update(query,parameters);
	}
	
	/** Adds user roles to a user in the database
	 * @param userId An long which represents the user ID of a user
	 * @param roleId An long which represents the role ID of a role
	 */
	public void addUserRoles(long userId, long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "insert into user_role (userId, roleId) values (:userId, :roleId);";
		parameters.addValue("userId",userId);
		parameters.addValue("roleId",roleId);
		jdbc.update(query,parameters);
	}
		

}
