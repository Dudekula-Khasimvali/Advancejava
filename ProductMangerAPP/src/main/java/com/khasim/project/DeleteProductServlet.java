package com.khasim.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId=request.getParameter("proId");
		int deleteResult=ProductsDao.deleteById(proId);
		
		if(deleteResult == 1) {
			request.setAttribute("deleteResult", deleteResult);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
			 			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("deleteResult", deleteResult);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
			 			dispatcher.include(request, response);
		}	
	}
}