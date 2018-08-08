import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sorting {

	List<Employee> listOfEmp = new ArrayList<Employee>() ;
	Set<Integer> empIDSet = new HashSet<Integer>();
	
	Sorting(){}
	
	/**
	 * Custom Exception for duplicate employee ID user
	 * @author User29
	 *
	 */
	class DuplicateException extends Exception{
		DuplicateException(){
			super();
		}
	}
	
	/**
	 * Comparator for Sort By employee ID
	 * @author User29
	 *
	 */
	class sortByEmpID implements Comparator<Employee>{

		public int compare(Employee emp1, Employee emp2) {
			return emp1.getEmpID() - emp2.getEmpID();
		}
		
	}
	
	/**
	 * Comparator for Sort By employee Name
	 * @author User29
	 *
	 */
	class sortByEmpName implements Comparator<Employee>{
		
		public int compare(Employee emp1, Employee emp2) {
			return String.CASE_INSENSITIVE_ORDER.compare(emp1.getEmpName(), emp2.getEmpName());
		}
	}
	
	/**
	 * Add employee to the list
	 * @param empID - employee ID
	 * @param empName - employee Name
	 * @param empAddress - employee address
	 */
	public void addEmp(int empID, String empName, String empAddress) {
		try {
			if(empIDSet.contains(empID)) {
				throw new DuplicateException();
			}
			else {
				empIDSet.add(empID);
			}
			Employee emp = new Employee(empID, empName, empAddress);
			this.listOfEmp.add(emp);
		}catch(DuplicateException e) {
			System.out.println("Employee ID with " + empID + " already exist.");
		}
	}
	
	/**
	 * Sort By employee ID
	 * @return - Sorted List by Employee ID
	 */
	public List<Employee> naturalSort(){
		
		Collections.sort(this.listOfEmp, new sortByEmpID());
		return this.listOfEmp;
	}
	
	/**
	 * Sort By Employee Name
	 * @return - Sorted List by Employee Name
	 */
	public List<Employee> sortByName(){
		
		Collections.sort(this.listOfEmp, new sortByEmpName());
		return this.listOfEmp;
	}
}
