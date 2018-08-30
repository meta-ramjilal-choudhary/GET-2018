package com.databaseAccessObject;

public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public Employee(String firstName, String lastName, String email, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	
	/**
	 * 
	 * @return - first name of employee
	 */
	public String getFirstName(){
		return this.firstName;
	}
	
	/**
	 * 
	 * @return - last name of employee
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	/**
	 * 
	 * @return - email of employee
	 */
	public String getEmail(){
		return this.email;
	}
	
	/**
	 * 
	 * @return - Age of employee
	 */
	public int getAge(){
		return this.age;
	}
}
