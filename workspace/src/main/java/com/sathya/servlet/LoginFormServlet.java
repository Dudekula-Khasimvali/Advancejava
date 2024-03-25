package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginFormServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Read the data
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		// process the data
		String status;
		if(username.equals("khasim") && password.equals("khasim@123"))
		{
			status="Login Successfull";
		}
		else 
		{
			status="Login Failed";
		}
		
		// render the response to client
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1> LOGIN STATUS </h1>"+status);
		writer.println("</html>");
	}
}