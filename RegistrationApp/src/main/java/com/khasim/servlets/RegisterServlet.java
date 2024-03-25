package com.khasim.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
			//read the data
		String Username=request.getParameter("Username");
		String password=request.getParameter("password");
		long Mobile=Long.parseLong(request.getParameter("Mobile"));
		String Email=request.getParameter("Email");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String[] quals=request.getParameterValues("qualification");
		String [] lang=request.getParameterValues("languages");
		String country=request.getParameter("country");
		String comments=request.getParameter("comments");
		
		//Step-2 Process the data
		String q=String.join(",", quals);
		String l=String.join("-", lang);
		
		//Step-3 Render the Response to client
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Register Form Appl..</h1>");
		writer.println("<body bgcolor=seafoem>");
		writer.println("Username="+Username);
		writer.println("<br><br>");
		writer.println("password="+password);
		writer.println("<br><br>");
		writer.println("Mobile="+Mobile);
		writer.println("<br><br>");
		writer.println("Email="+Email);
		writer.println("<br><br>");
		writer.println("dob="+dob);
		writer.println("<br><br>");
		writer.println("gender="+gender);
		writer.println("<br><br>");
		writer.println("qualification="+q);
		writer.println("<br><br>");
		writer.println("languages="+l);
		writer.println("<br><br>");
		writer.println("country="+country);
		writer.println("<br><br>");
		writer.println("comments="+comments);
		writer.println("</html>");		
	}
}