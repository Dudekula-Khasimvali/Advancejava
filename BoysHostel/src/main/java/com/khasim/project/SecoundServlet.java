//package com.khasim.project;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/SecoundServlet")
//public class SecoundServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 // Read form data
//        String email = request.getParameter("email");
//        String hostelId = request.getParameter("hostel_id");
//        String name = request.getParameter("name");
//
//        // Create a Hostel object
//        Hostel hostel = new Hostel();
//        hostel.setEmail(email);
//        hostel.setHostelId(hostelId);
//        hostel.setName(name);
//
//        // Pass the Hostel object to the DAO method for registration
//        int result = HostelDao.class(hostel);
//
//        if (result > 0) {
//            // Registration successful, redirect to a success page
//            response.sendRedirect("Hostel.jsp");
//        } else {
//            // Registration failed, redirect to an error page
//            response.sendRedirect("register.html");
//        }
//    }
//	}