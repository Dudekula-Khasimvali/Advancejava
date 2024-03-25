package com.khasim.project;

import java.sql.*;
public class HostelConnection {

	
	public  static Connection Connection() {
		// this method can be create Connection and return Connection
		Connection connection=null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","khasim","welcome");	
				}
				catch(ClassNotFoundException|SQLException e) {
					e.printStackTrace();
				}
		return connection;
	}
}
