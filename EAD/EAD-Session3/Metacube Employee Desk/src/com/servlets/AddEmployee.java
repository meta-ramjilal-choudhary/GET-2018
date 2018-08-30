package com.servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseAccessObject.JDBCConnection;
import com.databaseAccessObject.OperationOnEmployee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		OperationOnEmployee operation = new OperationOnEmployee() ;
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h1> " +  operation.insertEmployeeDetails(firstName, lastName, email, age) + " <h1>");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_employee.html"); 
		requestDispatcher.include(request, response);
	}

}
