package com.khasim.cookies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecoundServlet")
public class SecoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qualification=request.getParameter("qualification");
		String designation=request.getParameter("designation");
		
		//Create cookies object 
		Cookie  cookie = new Cookie("qua",qualification);
		Cookie  cookie1 = new Cookie("desg",designation);
		
		//addd the Cookies into rsponse Object
		
		response.addCookie(cookie);
		response.addCookie(cookie1);
		
		RequestDispatcher dis=request.getRequestDispatcher("Third.html");
		dis.forward(request, response);
		
	}

}
