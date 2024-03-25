package com.khasim.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NumberlistServlet")
public class NumberlistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String snum1Str = request.getParameter("snum1");
            String enum2Str = request.getParameter("enum2");
            String operation = request.getParameter("operation");

            if (snum1Str == null || enum2Str == null || operation == null) {
                throw new IllegalArgumentException("Parameters cannot be null.");
            }

            int snum1 = Integer.parseInt(snum1Str);
            int enum2 = Integer.parseInt(enum2Str);

            if (snum1 >= enum2) {
                throw new IllegalArgumentException("Starting number should be less than ending number.");
            }

            ArrayList<Integer> result = new ArrayList<>();

            switch (operation) {
                case "EVEN":
                    for (int i = snum1; i <= enum2; i++) {
                        if (i % 2 == 0) {
                            result.add(i);
                        }
                    }
                    break;
                case "ODD":
                    for (int i = snum1; i <= enum2; i++) {
                        if (i % 2 != 0) {
                            result.add(i);
                        }
                    }
                    break;
                case "PRIME":
                    for (int i = snum1; i <= enum2; i++) {
                        if (isPrime(i)) {
                            result.add(i);
                        }
                    }
                    break;
                case "PERFECT":
                    for (int i = snum1; i <= enum2; i++) {
                        if (isPerfect(i)) {
                            result.add(i);
                        }
                    }
                    break;
                case "STRONG":
                    for (int i = snum1; i <= enum2; i++) {
                        if (isStrong(i)) {
                            result.add(i);
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation: " + operation);
            }

            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<head><title>Generated Numbers Result</title></head>");
            writer.println("<body bgcolor=\"#ffe6e6\">");
            writer.println("<h2>Generated Numbers Result</h2>");
            writer.println("<p>Operation: " + operation + "</p>");
            writer.println("<p>Starting Number: " + snum1 + "</p>");
            writer.println("<p>Ending Number: " + enum2 + "</p>");
            writer.println("<p>Result Numbers: " + result.toString() + "</p>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (NumberFormatException ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format. Please enter valid numbers.");
        } catch (IllegalArgumentException ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPerfect(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) {
                    sum += n / i;
                }
            }
        }
        return sum == n && n != 1;
    }

    private boolean isStrong(int n) {
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == n;
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
