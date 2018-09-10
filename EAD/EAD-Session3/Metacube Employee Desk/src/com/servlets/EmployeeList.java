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
 * Servlet implementation class EmployeeList
 */
public class EmployeeList extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperationOnEmployee operation = new OperationOnEmployee();
		List<Employee> listOfEmployee = operation.listOfEmployee();
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
			pw.println("<title>");
				pw.println("List of Employees");
			pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table width='100%'");
		for(Employee emp : listOfEmployee){
			pw.println("<tr>");
				pw.println("<td>");
					pw.println(emp.getFirstName());
				pw.println("</td>");
				pw.println("<td>");
					pw.println(emp.getLastName());
				pw.println("</td>");
				pw.println("<td>");
					pw.println(emp.getEmail());
				pw.println("</td>");
				pw.println("<td>");
					pw.println(emp.getAge());
				pw.println("</td>");
				pw.println("<form id='update_employee' action='updateEmployee'>");
				pw.println("<td>");
					pw.println("<input type='hidden' name='email' value='" + emp.getEmail() + "' />");
				pw.println("</td>");
				pw.println("<td>");
					pw.println("<input type='submit' name='submit' value='update' />");
				pw.println("</td>");
				pw.println("</form>");
			pw.println("</tr>");
		}	
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
}
