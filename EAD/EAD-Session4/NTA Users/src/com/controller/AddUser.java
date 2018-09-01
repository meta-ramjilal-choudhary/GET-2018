package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.UserFacade;
import com.model.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = request.getParameter("dob");
		Date dob=null;
		try {
			dob = new Date(sdf.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String mobileNumber = request.getParameter("mobile_number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String organization = request.getParameter("organization");
		PrintWriter out = response.getWriter();
		FormValidation form = new FormValidation();
		if(form.isFormValid(firstName, lastName, mobileNumber, email, password)){
			UserFacade userFacade = UserFacade.getInstance();
			User user = userFacade.insertUserDetail(firstName, lastName, dob, mobileNumber, 
					email, password, organization);
			if(user == null){
				out.println("<h1 style='color:red'> User already exist with this email !! </h1>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign_up.html"); 
				requestDispatcher.include(request, response);
			}
			else{
				out.println(ProfileView.getProfileWebHTML(user));
			}
		}
		else{
			out.println("<h1 style='color:red'> Invalid input ! Please insert valid inputs. </h1>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign_up.html"); 
			requestDispatcher.include(request, response);
		}
	}

}
