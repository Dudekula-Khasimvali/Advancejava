package com.khasim.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Read the Data from From
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		double proPrice = Double.parseDouble(request.getParameter("proPrice"));		
		String proBrand=request.getParameter("proBrand");
		String proMadein=request.getParameter("proMadein");
		Date proMfgdate = Date.valueOf(request.getParameter("proMfgdate")); 
        Date proExpdate = Date.valueOf(request.getParameter("proExpdate"));
		
        Part part = request.getPart("proImage");
		InputStream inputstream = part.getInputStream();
		byte[] proImage = IOUtils.toByteArray(inputstream);
		
		Part part1 = request.getPart("proAudio");
		InputStream inputstream1 = part1.getInputStream();
		byte[] proAudio = IOUtils.toByteArray(inputstream1);

		Part part2 = request.getPart("proVideo");
		InputStream inputstream2 = part2.getInputStream();
		byte[] proVideo = IOUtils.toByteArray(inputstream2);

		
		//Using the Above Details Create the product Details
		Products pd = new Products();
				 pd.setProId(proId);
				 pd.setProName(proName);
				 pd.setProPrice(proPrice);
				 pd.setProBrand(proBrand);
				 pd.setProMadein(proMadein);
				 pd.setProMfgdate(proMfgdate);
				 pd.setProExpdate(proExpdate);
				 pd.setProImage(proImage);
				 pd.setProAudio(proAudio);
				 pd.setProVideo(proVideo);
				 				 
		//Giving The Product Object To DAO Layer
				 int result = ProductsDao.save(pd);			
				 
				 if(result==1) {
					 		//to add the result into jsp to check for message
					 	request.setAttribute("result", result);
					 RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
					 			dispatcher.forward(request, response);
				 }
				 else {
					 response.setContentType("text/html");
					 PrintWriter writer = response.getWriter();
					 writer.println("<h3>Data  Insertion Failed Check Once</h3>");
					 RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
					 			dispatcher.include(request, response);
				 }
	}
}