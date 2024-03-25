package com.khasim.projects;
import java.sql.*;

public class UserDAO {

	    public static int save(Player p) {
	        int result = 0;
	        Connection connection = null;
	        PreparedStatement ps = null;
	        try {
	            connection = DBConnection.getConnection();
	            ps = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
	            ps.setString(1, p.getUsername());
	            ps.setString(2, p.getPassword());
	            
	            // Execute the insert query
	            result = ps.executeUpdate();
	            
	            // Commit the transaction
	            connection.commit();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Rollback the transaction if an exception occurs
	            if (connection != null) {
	                try {
	                    connection.rollback();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        } finally {
	            // Close PreparedStatement and Connection
	            if (ps != null) {
	                try {
	                    ps.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return result;
	    }

	    public static int login(String username, String password) {
	        int isAuthenticated = 0;
	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ? AND password = ?")) {
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                int count = rs.getInt(1);
	                isAuthenticated = count > 0 ? 1 : 0; // Update isAuthenticated based on the count returned by the query
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return isAuthenticated;
	    }
}