package com.khasim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalculatorServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Step-1 read the data
	int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String operation=request.getParameter("operation");
		
		// Step-2 process the data
		int result=0;
		switch(operation) {
				case "+":result=num1+num2;
					break;
				case "-":result=num1-num2;
				break;
				case "*":result=num1*num2;
				break;
				case "/":result=num1/num2;
				break;
				case "%":result=num1%num2;
		}
		// render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h1> Calculator Appli..</h1>");
		writer.println("First Number="+num1);
		writer.println("<br><br>");
		writer.println("Secound Number="+num2);
		writer.println("<br><br>");
		writer.println("Selected Operation=" + operation);
		writer.println("<br><br>");
		writer.println("Operation Result="+result);
		writer.println("<br><br>");
		writer.println("</html>");	
	}
}