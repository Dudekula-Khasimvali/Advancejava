package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int HRA;
	private int DA;
	private int PF;

    
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Read The Data
		int empId=Integer.parseInt(request.getParameter("empId"));
		 String empName=request.getParameter("empName");
		int empSalary=Integer.parseInt(request.getParameter("empSalary"));
		
		//step-2 process the data
				int basicsalary=empSalary;
			float HRA = 0,DA = 0,PF = 0,gs;
			
				double netprice,discount=0;
				if( basicsalary>=50000) {
					DA=(10*basicsalary)/100;
					HRA=(30*basicsalary)/100;
					PF=(6*basicsalary)/100;
				}
				else if(basicsalary>25000 && basicsalary<50000) {
					DA=(5*basicsalary)/100;
					HRA=(20*basicsalary)/100;
					PF=(3*basicsalary)/100;
				}
				else {
					DA=(3*basicsalary)/100;
					HRA=(10*basicsalary)/100;
					PF=(2*basicsalary)/100;
				}
			gs=basicsalary+HRA+DA-PF;
			
			// Render the response to client
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<div style=text-align:center;>");
			writer.println("<body bgcolor=pink>");
			writer.println("<br><br>");
			writer.println("Employee id="+empId);
			writer.println("<br><br>");
			writer.println("Employee name="+empName);
			writer.println("<br><br>");
			writer.println("Employee salary="+empSalary);
			writer.println("<br><br>");
			writer.println("HRA=" + HRA);
			writer.println("<br><br>");
			writer.println("DA=" + DA);
			writer.println("<br><br>");
			writer.println("PF=" + PF);
			writer.println("<br><br>");
			writer.println("Gross salary=" + gs);
			writer.println("</div>");
			writer.println("</body>");
			writer.println("</html>");
				
	}
}