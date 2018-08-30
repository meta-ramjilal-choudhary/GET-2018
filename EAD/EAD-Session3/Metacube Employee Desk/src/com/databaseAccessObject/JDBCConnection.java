package com.databaseAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	/**
	 * Static method for Connection established 
	 * @param dataBaseName - DATA BASE name
	 * @param userName - user name
	 * @param userPassword - user password
	 * @return - Connection object
	 */
	public static Connection connectionCall(String dataBaseName, String userName, String userPassword) {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName,userName, userPassword);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println("SQL Exception ! Exception in generating Connection.");;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
}
