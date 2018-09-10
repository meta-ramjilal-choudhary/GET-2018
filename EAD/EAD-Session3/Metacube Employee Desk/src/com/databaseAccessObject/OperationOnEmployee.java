package com.databaseAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationOnEmployee {

	private Connection connection;
	
	public OperationOnEmployee(){
		this.connection = JDBCConnection.connectionCall("metacube", "root", "1025");
	}
	
	/**
	 * Insert Employee Details in Database
	 * @param firstName -  first name of employee
	 * @param lastName - last name of employee
	 * @param email - email of employee
	 * @param age - age of employee
	 */
	public String insertEmployeeDetails(String firstName, String lastName, String email, String age){
		try{
			if(connection == null){
				return "Connection does not established!";
			}
			if(this.isEmailExist(email)){
				return "Email is already used!";
			}
			else {
				String query = "INSERT INTO Employee (first_name, last_name, email, age) VALUES (?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setString(3, email);
				preparedStatement.setInt(4, Integer.parseInt(age));
				preparedStatement.executeUpdate();
				return "Welcome, " + firstName + " " + lastName;
			}
		}catch(SQLException e){
			return "SQL Exception " + e.getMessage();
		}
	}
	
	/**
	 * Check whether given email present in database or not
	 * @param email - new employee email
	 * @return - true if email present otherwise false
	 */
	private boolean isEmailExist(String email){
		try{
			String query = "SELECT email FROM Employee WHERE email = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
		return true;
	}
	
	/**
	 * List of Employee
	 * @return - List of employee
	 */
	public List<Employee> listOfEmployee(){
		List<Employee> employeeList = new ArrayList<Employee>();
		try{
			String query = "SELECT first_name, last_name, email, age FROM Employee";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				do{
					employeeList.add(new Employee(resultSet.getString("first_name"), 
							resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age")));	
				}while(resultSet.next());
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println("Null Pointer Exception");
		}catch(Exception e){
			System.out.println(e);
		}
		return employeeList;
	}
	
	/**
	 * List of employee which has following first name and last name
	 * @param firstName - first name of employee
	 * @param lastName - last name of employee
	 * @return - list of employee
	 */
	public List<Employee> listOfSearchEmployee(String firstName, String lastName){
		List<Employee> employeeList = new ArrayList<Employee>();
		try{
			String query = "SELECT first_name, last_name, email, age FROM Employee"
					+ " WHERE first_name LIKE ? OR last_name LIKE ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + firstName + "%");
			preparedStatement.setString(2, "%" + lastName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				do{
					employeeList.add(new Employee(resultSet.getString("first_name"), 
							resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age")));	
				}while(resultSet.next());
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println("Null Pointer Exception");
		}catch(Exception e){
			System.out.println(e);
		}
		return employeeList;
	}
	
	/**
	 * Update Employee Details in Database
	 * @param firstName -  first name of employee
	 * @param lastName - last name of employee
	 * @param email - email of employee
	 * @param age - age of employee
	 */
	public String updateEmployeeInTable(String firstName, String lastName, String email, String age){
		try{
			if(connection == null){
				return "Connection does not established!";
			}
			else {
				String query = "UPDATE Employee SET first_name = ?, last_name = ?, age = ? WHERE email = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setInt(3, Integer.parseInt(age));
				preparedStatement.setString(4, email);
				preparedStatement.executeUpdate();
				return "Updated !";
			}
		}catch(SQLException e){
			return "SQL Exception " + e.getMessage();
		}
	}
	
}
