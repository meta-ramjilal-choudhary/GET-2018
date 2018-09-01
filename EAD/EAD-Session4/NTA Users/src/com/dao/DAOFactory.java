package com.dao;

public class DAOFactory {

	public static BaseDAO getDAOObject(String DBName){
		BaseDAO baseDAO = null;
		if(DBName.equals("mysql")){
			baseDAO = MysqlDAO.getInstance();
		}
		return baseDAO;
	}
	
}
