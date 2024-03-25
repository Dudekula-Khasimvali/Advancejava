package com.khasim.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//get data from client
				String email=request.getParameter("email");	
				String mobile = request.getParameter("mobile");
				
					//Create a Session Object
					HttpSession session=request.getSession(false);
					
					response.setContentType("text/html");
					PrintWriter w=response.getWriter();
					w.println("<html>");
					w.println("<pre style=color:red>");
					w.println("UserName ="+session.getAttribute("username"));
					w.println("Age ="+session.getAttribute("age"));
					w.println("Qualification="+session.getAttribute("qual"));
					w.println("Designation="+session.getAttribute("desg"));
					w.println("User Email ="+email);
					w.println("User Mobile ="+mobile);
					w.println("</pre>");
					w.println("</html>");
					
					
	}

}
