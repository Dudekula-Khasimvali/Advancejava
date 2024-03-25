package com.khasim.project;
import java.io.*;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the updated product information from the request parameters
        String proId = request.getParameter("proId");
        String updatedProductName = request.getParameter("proName");
        double updatedProductPrice = Double.parseDouble(request.getParameter("proPrice"));
        String updatedProductBrand = request.getParameter("proBrand");
        String updatedProductMadeIn = request.getParameter("proMadein");
        Date updatedProductMfgDate = Date.valueOf(request.getParameter("proMfgdate"));
        Date updatedProductExpDate = Date.valueOf(request.getParameter("proExpdate"));

        // Create a Products object and set the updated information
        Products updatedProduct = new Products();
        updatedProduct.setProId(proId);
        updatedProduct.setProName(updatedProductName);
        updatedProduct.setProPrice(updatedProductPrice);
        updatedProduct.setProBrand(updatedProductBrand);
        updatedProduct.setProMadein(updatedProductMadeIn);
        updatedProduct.setProMfgdate(updatedProductMfgDate);
        updatedProduct.setProExpdate(updatedProductExpDate);

        // Handle the new image upload
        Part filePart = request.getPart("newproImage");

        if (filePart != null && filePart.getSize() > 0) {
            InputStream inputStream = filePart.getInputStream();
            byte[] newImageBytes = IOUtils.toByteArray(inputStream);
            updatedProduct.setProImage(newImageBytes);
        } else {
            // If no new image is uploaded, use the existing image
            String existingImageData = request.getParameter("existingImage");
            byte[] existingImageBytes = Base64.getDecoder().decode(existingImageData);
            updatedProduct.setProImage(existingImageBytes);
        }

       /* //Handle the Audio
        Part filePart1 = request.getPart("newproAudio");

        if (filePart1 != null && filePart1.getSize() > 0) {
            InputStream inputStream1 = filePart1.getInputStream();
            byte[] newAudioBytes = IOUtils.toByteArray(inputStream1);
            updatedProduct.setProAudio(newAudioBytes); // You missed this line to set proAudio
        } else {
            // If no new Audio is uploaded, use the existing Audio
            String existingAudioData = request.getParameter("existingAudio");
            byte[] existingAudioBytes = Base64.getDecoder().decode(existingAudioData);
            updatedProduct.setProAudio(existingAudioBytes);
        }*/

        // Perform the database update operation
        int Uresult = ProductsDao.UpdateById(updatedProduct);

        // Redirect to appropriate page based on the result of the update operation
        if (Uresult == 1) {
            request.setAttribute("Uresult", Uresult);
            RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("Data insertion failed. Please check and try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
            dispatcher.include(request, response);
        }
    }
}
