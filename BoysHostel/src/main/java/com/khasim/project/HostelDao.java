package com.khasim.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HostelDao {
    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/khasim";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // SQL queries
    private static final String INSERT_USER_QUERY = "INSERT INTO users (email, phone, aadhar) VALUES (?, ?, ?)";
    private static final String INSERT_HOSTEL_QUERY = "INSERT INTO hostels (name, specific_field) VALUES (?, ?)";

    // Method to insert user registration data into the database
    public boolean insertUserRegistration(String email, String phone, String aadhar) {
        try (
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY);
        ) {
            statement.setString(1, email);
            statement.setString(2, phone);
            statement.setString(3, aadhar);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to insert hostel registration data into the database
    public boolean insertHostelRegistration(String hostelName, String specificField) {
        try (
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(INSERT_HOSTEL_QUERY);
        ) {
            statement.setString(1, hostelName);
            statement.setString(2, specificField);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}