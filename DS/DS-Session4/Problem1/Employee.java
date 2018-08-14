
public class Employee {

	private int empID;
	private String empName;
	private String empAddress;
	
	Employee(int empID, String empName, String empAddress){
		this.empID = empID;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	/**
	 * 
	 * @return - employee ID
	 */
	public int getEmpID() {
		return this.empID;
	}
	
	/**
	 * 
	 * @return - Employee name
	 */
	public String getEmpName() {
		return this.empName;
	}
	
	/**
	 * 
	 * @return - Employee address
	 */
	public String getEmpAddress() {
		return this.empAddress;
	}
}
