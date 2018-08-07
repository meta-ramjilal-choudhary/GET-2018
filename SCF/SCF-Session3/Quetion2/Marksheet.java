import java.lang.ArithmeticException;
import java.lang.Math;

public class Marksheet {
	
	private double grades[];
	
	Marksheet(){}
	
	/*
	 * @param  grades - Student grades array
	 * @return nothing
	 */
	Marksheet(double grades[]){
		this.grades = grades;
	}
	
	/*
	 * Compute Average of All grades of students
	 * @param   nothing
	 * @return  double - Average of all grades
	 */
	public double averageOfAllGrades() throws ArithmeticException{
		
		double gradesTotal = 0.0;
		for(int index=0; index < this.grades.length; index++) {
			gradesTotal += this.grades[index];
		}
		double avgGrades =  gradesTotal / (double)this.grades.length;
		return Math.round(avgGrades* 100.0)/100.0;
	}
	
	/* 
	 * Compute Maximum grade of all grades
	 * @param  nothing
	 * @return double - maximum of all grades
	 */
	public double maximumOfAllGrades() throws ArithmeticException{
		double maximumGrade = 0.0;
		for(int index=0; index < this.grades.length; index++) {
			maximumGrade = Math.max(maximumGrade, this.grades[index]);
		}
		return Math.round(maximumGrade * 100.0) / 100.0;
	}
	
	/* 
	 * Compute Minimum grade of all grades
	 * @param  nothing
	 * @return double - Minimum of all grades
	 */
	public double minimumOfAllGrades() v{
		double minimumGrade = 101.0;
		for(int index=0; index < this.grades.length; index++) {
			minimumGrade = Math.min(minimumGrade, this.grades[index]);
		}
		return Math.round(minimumGrade * 100.0) / 100.0;
	}
	
	/*
	 * Compute percentage of students passed ( Passed if grade >= 40 )
	 * @param   nothing
	 * @return  double - percentage of student passed 
	 */
	public double percentageOfStudentPassed() throws ArithmeticException {
		int totalStudentPassed = 0;
		for(int index=0; index < this.grades.length; index++) {
			if (this.grades[index] >= 40.00) {
				totalStudentPassed ++;
			}
		}
		double percentage = ((double)totalStudentPassed / (double)this.grades.length) * 100.0;
		return Math.round(percentage * 100.0) / 100.0;
	}
}
