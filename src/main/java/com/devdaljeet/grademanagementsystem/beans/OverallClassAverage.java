package com.devdaljeet.grademanagementsystem.beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OverallClassAverage {
	
	private double avgExercises;
	private double avgAssignment1;
	private double avgAssignment2;
	private double avgAssignment3;
	private double avgMidterm;
	private double avgFinalExam;
	private double overallAverageGrade;

}
