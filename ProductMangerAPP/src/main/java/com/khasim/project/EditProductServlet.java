package com.khasim.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the data from productsDao Layer
		String proId=request.getParameter("proId");
		
		//Get the Existing Object from DAo Layer
		Products existingObject = ProductsDao.findById(proId);
			
			//to send the existingObject to edit-form.jsp file
		request.setAttribute("existingObject", existingObject);
			
			//Populate the existingObject details in edit-form.jsp file
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit-form.jsp");
 			dispatcher.forward(request, response);
}
}