package com.model;

import java.sql.Date;

public class User {

	private String firstName;
	private String lastName;
	private Date dob;
	private String mobileNumber;
	private String email;
	private String password;
	private String organization;
	private String imageUrl;
	
	User(){}
	
	public User(String firstName, String lastName, Date dob, String mobileNumber,
			String email, String password, String organization, String imageUrl){
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.organization = organization;
		this.imageUrl = imageUrl;
	}
	
	/**
	 * 
	 * @param firstName - first name of user
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @param lastName - last name of user
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @param dob - Date of birth of user
	 */
	public void setDOB(Date dob){
		this.dob = dob;
	}
	
	/**
	 * 
	 * @param mobileNumber - mobile number of user
	 */
	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * 
	 * @param password - Password of user
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * 
	 * @param organization - organization of user
	 */
	public void setOrganization(String organization){
		this.organization = organization;
	}
	
	/**
	 * 
	 * @param imageUrl - image user
	 */
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	
	/**
	 * 
	 * @return - first name of user
	 */
	public String getFirstName(){
		return this.firstName;
	}
	
	/**
	 * 
	 * @return - last name of user
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	/**
	 * 
	 * @return - Date of Birth of user
	 */
	public Date getDOB(){
		return this.dob;
	}
	
	/**
	 * 
	 * @return - mobile number of user
	 */
	public String getMobileNumber(){
		return this.mobileNumber;
	}
	
	/**
	 * 
	 * @return - email of user
	 */
	public String getEmail(){
		return this.email;
	}
	
	/**
	 * 
	 * @return - password of user
	 */
	public String getPassword(){
		return this.password;
	}
	
	/**
	 * 
	 * @return - Organization name of user
	 */
	public String getOrganization(){
		return this.organization;
	}
	
	/**
	 * 
	 * @return - image url of user
	 */
	public String getImageUrl(){
		return this.imageUrl;
	}
}
