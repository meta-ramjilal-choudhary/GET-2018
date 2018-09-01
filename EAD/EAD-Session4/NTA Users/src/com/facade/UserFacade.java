package com.facade;

import java.sql.Date;

import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.model.User;

public class UserFacade {

	private static UserFacade userFacade = new UserFacade();
 ;
	
	private UserFacade(){}
	
	/**
	 * Signlton Class object 
	 * @return - only single instance of given class
	 */
	public static UserFacade getInstance(){
		return userFacade;
	}
	
	/**
	 * Insert Facade of user
	 * @param firstName - first name of user
	 * @param lastName - last name of user
	 * @param dob - date of birth of user
	 * @param mobileNumber - mobile number of user
	 * @param email - email of user
	 * @param password - password of user
	 * @param organization - organization of user
	 * @return - User object
	 */
	public User insertUserDetail(String firstName, String lastName, Date dob, String mobileNumber,
			String email, String password, String organization){
		BaseDAO baseDAO = DAOFactory.getDAOObject("mysql");
		User user = baseDAO.getUserByEmail(email);
		if(user != null){
			return null;
		}
		return baseDAO.insertEmployeeDetails(firstName, lastName, dob, mobileNumber, email, password, organization);
	}
	
	/**
	 * Get user By email
	 * @param email - email of user
	 * @return - User object
	 */
	public User getUser(String email){
		BaseDAO baseDAO = DAOFactory.getDAOObject("mysql");
		return baseDAO.getUserByEmail(email);
	}
	
	/**
	 * Update user image url
	 * @param email - email of user
	 * @param imageUrl - new image url of user
	 */
	public void updateUserImage(String email, String imageUrl){
		BaseDAO baseDAO = DAOFactory.getDAOObject("mysql");
		baseDAO.updateImageOfUser(email, imageUrl);
	}
	
}
