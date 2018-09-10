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
 * Servlet implementation class updateEmployee
 */
public class UpdateEmployee extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperationOnEmployee operation = new OperationOnEmployee();
		List<Employee> listOfEmployee = operation.listOfEmployee();
		String email = request.getParameter("email");
		Employee employee = null;
		for(Employee emp : listOfEmployee){
			if(emp.getEmail().equals(email)){
				employee = emp;
				break;
			}
		}
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>");
			pw.println("List of Employees");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<form id='employeeDetailForm' action='updateEmployeeDetail'>");
		pw.println("<table width='100%'");
		pw.println("<tr>");
		pw.println("<td>");
			pw.println("<input type='text' name='first_name' value='"+ employee.getFirstName() +"' />");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
			pw.println("<input type='text' name='last_name' value='"+ employee.getLastName() +"' />");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
			pw.println("<input type='text' name='email' value='"+ employee.getEmail() +"' readonly />");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
			pw.println("<input type='text' name='age' value='"+ employee.getAge() +"' />");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
			pw.println("<input type='submit' name='value' />");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("<form>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
