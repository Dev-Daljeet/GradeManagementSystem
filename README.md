# Grade Management System

This project is a web application which manages the grades of different students. It performs CRUD (Create, read(view), update and delete) operations, calculates the
grade (average grade, letter grade and overall class average) of every student, registers a user (student/professor role) and use Spring security to allow/restrict 
the access of different URLs depending upon roles.

My objective behind this project was to learn Spring Security and use database to load users and add users rather than hard coding the users in security config class.

Programming language: Java

Java Framework: Spring Boot

Type: Maven

Dependencies used: Spring Web, Thymeleaf, Lombok, Spring data JDBC, H2 database and Spring Security

## Some sample screenshots of Project

### Homepage As Professor
![Screesshot of Homepage](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/homeProf.PNG?raw=true)

### Homepage As Student
![Screesshot of Homepage](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/homeStu.PNG?raw=true)

### Homepage without login as user
![Screesshot of Homepage](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/home.PNG?raw=true)

### Login page
![Screesshot of Homepage](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/login.PNG?raw=true)

### Add page
![Screesshot of add page](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/add.PNG?raw=true)

### View As Professor page
![Screesshot of viewAsProf 1 page](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/viewProf.PNG?raw=true)
![Screesshot of viewAsProf 2 page](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/viewProfAvg.PNG?raw=true)

### View As Student page
![Screesshot of viewAsStu page](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/viewStu.PNG?raw=true)

### Register page
![Screesshot of register page](https://github.com/Dev-Daljeet/Screenshots/blob/master/GradeManagement/register.PNG?raw=true)

## How the project (application) works:

(**Note:** Anyone can register as professor by clicking on register button. For student, when professor adds a student, the student gets added into user relation in the database. Thus, the newly added student can login using his/her name as username and studentId as password.)

### Professor (User with role Professor) can do following operations:
- Add a student (name, studentId, Exercises, Assignment 1, Assignment 2, Assignment 3, Midterm, Final Exam)
- View all students
- View average grade of every students
- View overall average of every section and overall average grade
- Edit the properties of student (name, studentId, Exercises, Assignment 1, Assignment 2, Assignment 3, Midterm, Final Exam)
- Delete the student

### Student (User with role Student) can do following operations:
- View his/her grade 
- View his/her average grade and letter grade

## Usage examples (How to use):
[![GradeManagementSystem](http://img.youtube.com/vi/ZD-FepDhBe8/0.jpg)](http://www.youtube.com/watch?v=ZD-FepDhBe8 "GradeManagementSystem")

## Run:
### Prerequisites (Requirements):

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.devdaljeet.grademanagementsystem.GradeManagementSystemApplication` class from your IDE (Eclipse).

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/Dev-Daljeet/GradeManagementSystem.git
$ cd GradeManagementSystem
$ mvn spring-boot:run
```

# License
MIT License
Copyright (c) 2020 Dev-Daljeet

Refer to **LICENSE** file for full information.
