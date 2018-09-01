package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;


public class MysqlDAO implements BaseDAO{
	
	private Connection connection;
	private static MysqlDAO mysqlDAO = new MysqlDAO();

	private MysqlDAO(){
		connection = JDBCConnection.connectionCall("nta", "root", "1025");
	}
	
	/**
	 * Single inctance for MysqlDAO 
	 * @return - MysqlDAO instance
	 */
	public static MysqlDAO getInstance(){
		return mysqlDAO;
	}
	
	/**
	 * Get user by email
	 * @param email - email of user
	 * @return - User Object
	 */
	public User getUserByEmail(String email){
		User user = null;
		try{
			String query = "SELECT first_name, last_name, dob, mobile_number, email,"
					+ "password, organization, image_url FROM User WHERE email = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				user = new User(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getDate("dob"),
						resultSet.getString("mobile_number"), resultSet.getString("email"), resultSet.getString("password"),
						resultSet.getString("organization"), resultSet.getString("image_url"));	
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
		return user;
	}
	
	/**
	 * Insert User Details in Database
	 * @param firstName -  first name of User
	 * @param lastName - last name of User
	 * @param email - email of User
	 * @param age - age of User
	 */
	public User insertEmployeeDetails(String firstName, String lastName, Date dob, String mobileNumber,
			String email, String password, String organization){
		User user = null;
		try{
			String query = "INSERT INTO User (first_name, last_name, dob, mobile_number, email,"
					+ "password, organization) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setDate(3, dob);
			preparedStatement.setString(4, mobileNumber);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, password);
			preparedStatement.setString(7, organization);
			preparedStatement.executeUpdate();
			return this.getUserByEmail(email);
		}catch(SQLException e){
			System.out.println("SQL Exception - " + e.getMessage());
		}
		return user;
	}
	
	/**
	 * Update user image url
	 * @param email - email of user
	 * @param imageUrl - new image url of user
	 */
	public void updateImageOfUser(String email, String imageUrl){
		try{
			String query = "UPDATE User SET image_url = ? WHERE email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, imageUrl);
			preparedStatement.setString(2, email);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			System.out.println("SQL Exception - " + e.getMessage());
		}
		
	}
	
}
