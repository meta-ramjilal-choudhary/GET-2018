
public class Student {

	private String studentName;
	private int regNumber;
	private int rank;
	private String prefProgramCodeList[];
	private Program program;
	
	Student(String studentName, int regNumber, int rank, String prefProgramCodeList[]){
		this.studentName = studentName;
		this.regNumber = regNumber;
		this.rank = rank;
		this.prefProgramCodeList = prefProgramCodeList;
		this.program = null;
	}
	
	/**
	 * 
	 * @return - name of a student
	 */
	public String getName() {
		return this.studentName;
	}
	
	/**
	 * 
	 * @return - rank of a student
	 */
	public int getRank() {
		return this.rank;
	}
	
	/**
	 * 
	 * @return -  Registration number of Student
	 */
	public int getRegNumber() {
		return this.regNumber;
	}
	
	/**
	 * 
	 * @param program - Set Program after counseling
	 */
	public void setProgram(Program program) {
		this.program = program;
	}
	
	/**
	 * 
	 * @return - Preference Program list of student
	 */
	public String[] getPrefProgramList() {
		return this.prefProgramCodeList;
	}
	
	/**
	 * 
	 * @return - Program after allocation
	 */
	public Program getAllocatedProgram() {
		return this.program;
	}
}
