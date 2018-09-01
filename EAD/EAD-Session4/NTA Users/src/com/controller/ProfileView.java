package com.controller;

import java.sql.Date;

import javax.servlet.http.HttpServlet;

import com.model.User;

public class ProfileView extends HttpServlet {

	public static String getProfileWebHTML(User user){
		return "<!DOCTYPE html>"
				+ "<html>"
					+"<head>"
						+"<title>"+ user.getFirstName() +"</title>"
						+"<style>"
							+"header{"
								+"background-color: #bbb;"
								+"text-align:center;"
								+"color : #260029;"
								+"padding:5px;"
								+"height: 100px;"
								+"font-family: 'Franklin Gothic Medium',"
								+ " 'Arial Narrow', Arial, sans-serif;}"
							+"nav{"
								+"background-color: aliceblue;"
								+"text-align: right;"
								+"padding : 5px;}"
							+"a{"
								+"padding : 5px;"
								+"margin : 5px;"
								+"background-color: aquamarine;"
								+"text-decoration: none;"
								+"color : #010629 ;}"
							+"body{"
								+"background-image: url('login_page.jpg');}"
						+"</style>"
					+"</head>"
					+"<body>"
						+"<header>"
							+"<table width='100%'>"
								+"<tr>"
									+"<td align='left'>"
										+"<img src='"+ user.getImageUrl() +"' alt='"+ user.getFirstName() +"' height='80px' />"
										+"<form method='POST' action='imageUpload' enctype='multipart/form-data'>"
											+"<input type='file' name='file'/ required>"
											+"<input type='hidden' name='email' value='"+ user.getEmail() +"' />"
											+"<input type='hidden' name='destination' "
											+ "value='C:\\Users\\User29\\Servlet\\NTA Users\\WebContent\\images' />"
											+"<input type='submit' name='upload' value='Upload'/>"
										+"</form>"
									+"</td>"
									+"<td align='right'>"
										+" <h1>"+ user.getFirstName() + " " + user.getLastName() +"</h1> "
									+"</td>"
								+"</tr>"
							+ "</table>"
						+"</header>"
						+"<nav>"
							+"<a href='home_page.html'> Log out </a>"
						+"</nav>"
					+"</body>"
						;
	}
	
}
