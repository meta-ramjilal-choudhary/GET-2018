package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseAccessObject.Employee;
import com.databaseAccessObject.OperationOnEmployee;

/**
 * Servlet implementation class SearchEmployee
 */
public class SearchEmployee extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperationOnEmployee operation = new OperationOnEmployee();
		List<Employee> listOfEmployee = operation.listOfSearchEmployee(request.getParameter("first_name")
				, request.getParameter("last_name"));
		PrintWriter pw = response.getWriter();
		if(listOfEmployee.size() == 0){
			pw.println("<h1> No Such Employee found ! </h1>");
		}
		else{
			for(Employee emp : listOfEmployee){
				pw.println("<html>");
				pw.println("<h1>" + emp.getFirstName() + " " + emp.getLastName() + " " + emp.getEmail() + " " + emp.getAge() + "</h1>");
				pw.println("</html>");
			}
		}
	}

}
