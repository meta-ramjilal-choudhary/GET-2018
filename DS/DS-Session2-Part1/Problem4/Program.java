import java.util.LinkedList;
import java.util.List;

public class Program {

	private String programName;
	private String programCode;
	private int capacity;
	private List<Student> students;
	
	Program(String programName, String programCode, int capacity){
		this.programName = programName;
		this.programCode = programCode;
		this.capacity = capacity;
		this.students = new LinkedList<Student>();
	}
	
	/**
	 * 
	 * @return - capacity of program
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * 
	 * @param newCapacity - new capacity after add student
	 */
	public void updateCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}
	
	/**
	 * 
	 * @param student - student object 
	 */
	public void addStudentToProgram(Student student) {
		this.students.add(student);
	}
	
	/**
	 * 
	 * @return - List of all students in this program 
	 */
	public List<Student> getListOfStudnets(){
		return this.students;
	}
	
	/**
	 * 
	 * @return - program code
	 */
	public String getCode() {
		return this.programCode;
	}
}
