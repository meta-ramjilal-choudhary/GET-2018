package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseAccessObject.OperationOnEmployee;

/**
 * Servlet implementation class UpdateEmployeeDetail
 */
public class UpdateEmployeeDetail extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperationOnEmployee operation = new OperationOnEmployee() ;
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h1> " +  operation.updateEmployeeInTable(firstName, lastName, email, age) + " <h1>");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee.html"); 
		requestDispatcher.include(request, response);
	}

}
