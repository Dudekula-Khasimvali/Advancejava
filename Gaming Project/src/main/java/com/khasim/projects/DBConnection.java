package com.khasim.projects;

	import java.sql.*;

	public class DBConnection {
	    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	    private static final String USERNAME = "khasim";
	    private static final String PASSWORD = "welcome";

	    public static Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            System.out.println("Connected to database.");
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
}