package com.khasim.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		//get Cookie Object
		Cookie[] c=request.getCookies();
		
		response.setContentType("text/html");
		PrintWriter w=response.getWriter();
		w.println("<html>");
		w.println("<body>");
		w.println("<pre style=color:blue;>");
		w.println("UserName: "+c[0].getValue());
		w.println("Age: "+c[1].getValue());
		w.println("Qualification: "+c[2].getValue());
		w.println("Designation: "+c[3].getValue());
		w.println("User Email="+email);
		w.println("User Mobile="+mobile);
		w.println("</pre>");
		w.println("</body>");
		w.println("</html>");
		
	}

}
