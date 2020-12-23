package com.devdaljeet.grademanagementsystem.beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	
	private int id;
	private String name;
	private String studentId;
	private double exercises;
	private double assignment1;
	private double assignment2;
	private double assignment3;
	private double midterm;
	private double finalExam;
	private double averageGrade;
	private String letterGrade;
	
	public void calcAverageGrade()
	{
		averageGrade = (10*exercises + 6*assignment1 + 12*assignment2 + 12*assignment3 + 30*midterm + 30*finalExam)/100;
		calcLetterGrade();
	}
	
	public void calcLetterGrade()
	{
		if (averageGrade<=100 && averageGrade>=90)
		{
			letterGrade = "A+";
		}
		else if (averageGrade>=85)
		{
			letterGrade = "A";
		}
		else if (averageGrade>=80)
		{
			letterGrade = "A-";
		}
		else if (averageGrade>=75)
		{
			letterGrade = "B+";
		}
		else if (averageGrade>=70)
		{
			letterGrade = "B";
		}
		else if (averageGrade>=65)
		{
			letterGrade = "C+";
		}
		else if (averageGrade>=60)
		{
			letterGrade = "C";
		}
		else if (averageGrade>=55)
		{
			letterGrade = "D+";
		}
		else if (averageGrade>=50)
		{
			letterGrade = "D";
		}
		else
		{
			letterGrade = "F";
		}
	}
	

}
