package com.controller;

import java.sql.Date;

public class FormValidation {

	FormValidation(){}
	
	/**
	 * 
	 * @param firstName - first name of user
	 * @param lastName - last name of user
	 * @param mobileNumber - mobile number of user
	 * @param email - email of user
	 * @param password - password of user
	 * @param organization - organization of user
	 * @return - true if form valid otherwise false
	 */
	public boolean isFormValid(String firstName, String lastName, String mobileNumber,
			String email, String password){
		
		if(!isNameValid(firstName) || !isNameValid(lastName) || !isNumeric(mobileNumber)
					|| !isEmailValid(email) || !isPasswordValid(password)){
			return false;
		}
		return true;
	}
	
	/**
	 * @param name - name of user
	 * @return - true if name valid otherwise false
	 */
	public boolean isNameValid(String name){
		if(name.length()<=2){
			return false;
		}
		return name.matches("[a-zA-Z]+");
	}
	
	/**
	 * 
	 * @param mobileNumber - mobile number of user
	 * @return - true if number is valid otherwise false
	 */
	public boolean isNumeric(String mobileNumber){
		if(mobileNumber.length() != 10){
			return false;
		}
		return mobileNumber.matches("\\d+");
	}
	
	/**
	 * 
	 * @param email - email of user
	 * @return - true if email is valid otherwise false
	 */
	public boolean isEmailValid(String email){
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
		return email.matches(regex);
	}
	
	/**
	 * 
	 * @param password - password of user
	 * @return - true if password is valid otherwise false
	 */
	public boolean isPasswordValid(String password){
		return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
	}
}
