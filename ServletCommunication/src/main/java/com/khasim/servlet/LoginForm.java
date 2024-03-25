package com.khasim.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	response.setContentType("text/html");
	PrintWriter w=response.getWriter();
	
	//REQUEST DISPATCHER
	if(username.equals("khasim") && password.equals("khasim@123"))
	{
			RequestDispatcher dr=request.getRequestDispatcher("login.html");
			dr.forward(request, response);
			
	}
	else {
		RequestDispatcher dr=request.getRequestDispatcher("login.html");
		dr.include(request, response);
	}
	
	//HYPERLINK CODE
	/*if(username.equals("khasim") && password.equals("khasim@123"))
	{
		w.println("LoginSuccessfull <br>");
		w.println("<a href=https://www.battlegroundsmobileindia.com>Click this Link To open Website</a>");
	}
	else {
		w.println("Login Failed Check Details One's Again<br>");
		w.println("<a href=login.html>Clik this Link to Open Login Form");
	}*/
		
	//Sendredirect Code
	
	/*if(username.equals("khasim") && password.equals("khasim@123"))
	{
		response.sendRedirect("https://www.battlegroundsmobileindia.com");
	}
	else {
		response.sendError(801 ,"LOGIN FAILED  CHECK DETAILS ONE'S AGAIN");
	}*/
	
	
	}
}