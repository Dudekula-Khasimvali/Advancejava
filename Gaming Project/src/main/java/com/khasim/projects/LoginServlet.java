package com.khasim.projects;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        int count = UserDAO.login(username, password); // Assuming UserDao is the class containing your login DAO method
        
        if (count == 1) {
            // Successful login
        	request.setAttribute("count", count);
            response.sendRedirect("home.jsp");
        } else {
            // Failed login
            response.sendRedirect("registration.html");
        }
    }
}