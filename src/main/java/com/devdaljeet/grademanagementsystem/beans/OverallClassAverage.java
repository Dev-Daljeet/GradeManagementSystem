package com.devdaljeet.grademanagementsystem.beans;

import lombok.*;

/** Represents the overall class average of a class.
 * (Note: lombok used for constructors, getters and setters)
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
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
