package com.khasim.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get data from client
	String username=request.getParameter("username");	
	int age=Integer.parseInt(request.getParameter("age"));
	
		//Create a Session Object
		HttpSession session=request.getSession();
		
		//place the data into Session Object
		session.setAttribute("username",username);
		session.setAttribute("age", age);
		
		//Give next Page to Client
		RequestDispatcher dis=request.getRequestDispatcher("secound.html");
				dis.forward(request, response);
	}

}
