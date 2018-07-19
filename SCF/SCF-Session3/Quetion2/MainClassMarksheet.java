
public class MainClassMarksheet extends Marksheet {
	
	public static void main(String args[]) {
		double grades[] = {50.454, 44.6945, 60.6714, 50.3312, 40.2125, 10.2008};
		Marksheet marksheet = new Marksheet(grades);
		System.out.println(marksheet.averageOfAllGrades());
		System.out.println(marksheet.maximumOfAllGrades());
		System.out.println(marksheet.minimumOfAllGrades());
		System.out.println(marksheet.percentageOfStudentPassed());
	}
}
