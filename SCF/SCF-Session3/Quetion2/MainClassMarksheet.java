
public class MainClassMarksheet extends Marksheet {
	
	public static void main(String args[]) {
		double grades[] = {50.454, 44.6945, 60.6714, 50.3312, 40.2125, 10.2008};
		Marksheet marksheet = new Marksheet(grades);
		System.out.println("Average of All grades : " + marksheet.averageOfAllGrades());
		System.out.println("Maximum of all grades: " + marksheet.maximumOfAllGrades());
		System.out.println("Minimum of all grades: " + marksheet.minimumOfAllGrades());
		System.out.println("Percentage of student passed: " + marksheet.percentageOfStudentPassed());
	}
}
