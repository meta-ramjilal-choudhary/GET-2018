import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.databaseAccessObject.Employee;
import com.databaseAccessObject.JDBCConnection;
import com.databaseAccessObject.OperationOnEmployee;


public class DAOTest {

//	@Test
//	public void testInsertEmployeeDetails() {
//		OperationOnEmployee operation = new OperationOnEmployee();
//		String result1 = operation.insertEmployeeDetails("Ramjilal", "choudhary", "ramjilal@gmail.com", "12");
//		assertEquals("Welcome, Ramjilal choudhary", result1);
//		String result2 = operation.insertEmployeeDetails("Ramjilal", "choudhary", "ramjilal@gmail.com", "12");
//		assertEquals("Email is already used!", result2);
//	}
//	
//	@Test
//	public void testListOfEmployee(){
//		Connection connection = JDBCConnection.connectionCall("metacube", "root", "1025");
//		OperationOnEmployee operation = new OperationOnEmployee();
//		List<Employee> employeeList = operation.listOfEmployee();
//		List<String> emails = new ArrayList<String>();
//		String query = "SELECT email FROM Employee";
//		try{
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if(resultSet.next()){
//				do{
//					emails.add(resultSet.getString("email"));	
//				}while(resultSet.next());
//			}
//			assertEquals(emails.size(), employeeList.size());
//		}catch(SQLException e){
//			System.out.println(e);
//		}
//	}
	
	@Test
	public void testSearchEmployee(){
		Connection connection = JDBCConnection.connectionCall("metacube", "root", "1025");
		OperationOnEmployee operation = new OperationOnEmployee();
		List<Employee> employeeList = operation.listOfSearchEmployee("ram", "choudhary");
		for(Employee emp : employeeList){
			System.out.println(emp.getEmail() + " " + emp.getAge());
		}
	}

}
