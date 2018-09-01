package com.dao;

import java.sql.Date;

import com.model.User;

public interface BaseDAO {

	public User getUserByEmail(String email);
	
	public User insertEmployeeDetails(String firstName, String lastName, Date dob, String mobileNumber,
			String email, String password, String organization);
	
	public void updateImageOfUser(String email, String imageUrl);
}
