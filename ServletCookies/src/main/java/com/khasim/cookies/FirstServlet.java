package com.khasim.cookies;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		
		//Create Cookie Object
		Cookie cookie = new Cookie("username", username);
		Cookie cookie1= new Cookie("age",age);
		
		//add the Cookies into response object
		response.addCookie(cookie);
		response.addCookie(cookie1);
		
		RequestDispatcher dis=request.getRequestDispatcher("Secound.html");
		dis.forward(request, response);
		
		
	}

}
