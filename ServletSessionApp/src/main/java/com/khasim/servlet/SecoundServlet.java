package com.khasim.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecoundServlet")
public class SecoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get data from client
		String qualification=request.getParameter("qualification");	
		String designation=request.getParameter("designation");
		
			//Create a Session Object
			HttpSession session=request.getSession(false);
			
			//place the data into Session Object
			session.setAttribute("qual",qualification);
			session.setAttribute("desg", designation);
			
			//Give next Page to Client
			RequestDispatcher dis=request.getRequestDispatcher("third.html");
					dis.forward(request, response);
	}

}
