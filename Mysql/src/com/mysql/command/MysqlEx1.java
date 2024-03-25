package com.mysql.command;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlEx1 {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/khasim";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            System.out.println("Connection Created Successfully");

            // Creating PreparedStatement Object
            PreparedStatement ps = connection.prepareStatement("INSERT INTO emp VALUES (?, ?, ?)");

            // Set data to Question Marks and add to batch
            ps.setInt(1, 1);
            ps.setString(2, "pavan");
            ps.setFloat(3, 1500.01f);
            ps.addBatch();

            ps.setInt(1, 2);
            ps.setString(2, "kalyan");
            ps.setFloat(3, 25000.1f);
            ps.addBatch();

            ps.setInt(1, 3);
            ps.setString(2, "ram");
            ps.setFloat(3, 35000.2f);
            ps.addBatch();

            // Execute the batch
            ps.executeBatch();
            System.out.println("Data inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}