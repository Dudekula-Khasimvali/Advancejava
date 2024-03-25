package com.khasim.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FullnameSevlet
 */
@WebServlet("/FullnameSevlet")
public class FullnameSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FullnameSevlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			String FirstName=request.getParameter("FirstName");
			String MiddleName=request.getParameter("MiddleName");
			String LastName=request.getParameter("LastName");
			
			//process the data
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<h1>Fullname</h1>");
			writer.println("<br><br>");
			writer.println("FirstName="+FirstName);
			writer.println("<br><br>");
			writer.println("MiddleName="+MiddleName);
			writer.println("<br><br>");
			writer.println("LastName="+LastName);
			writer.println("<br><br>");
			writer.println("Fullname="+FirstName+MiddleName+LastName);
			writer.println("<br><br>");
			writer.println("</html>");
	}
}
