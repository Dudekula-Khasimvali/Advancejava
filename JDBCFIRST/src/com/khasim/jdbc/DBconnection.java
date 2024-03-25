package com.khasim.jdbc;

import java.sql.*;

public class DBconnection {
	public  static Connection createConnection() {
		// this method can be create Connection and return Connection
		Connection c=null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","khasim","welcome");	
				}
				catch(ClassNotFoundException |SQLException e) {
					e.printStackTrace();
				}
		return c;
	}
}