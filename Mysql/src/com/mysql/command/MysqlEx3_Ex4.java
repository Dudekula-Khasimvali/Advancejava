package com.mysql.command;
import java.sql.*;
public class MysqlEx3_Ex4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/khasim","root","root");
		//creating statement object
		Statement s=c.createStatement();
		//taking Resultset object
		ResultSet set=s.executeQuery("select * from emp");
		//setting Metadata of resultset
		ResultSetMetaData metadata=set.getMetaData();
		System.out.println("ResultSetMetaData Created");
		System.out.println(metadata.getColumnCount());
		System.out.println(metadata.getColumnDisplaySize(2));
		System.out.println(metadata.getColumnClassName(1));
		System.out.println(metadata.getColumnType(3));
		System.out.println(metadata.getColumnName(1));
		System.out.println(metadata.getColumnLabel(2));
		System.out.println(metadata.getColumnTypeName(3));	
		
		
		DatabaseMetaData md=c.getMetaData();
		System.out.println("DatabaseMetaData Created");
		System.out.println(md.getDatabaseProductName());
		System.out.println(md.getDatabaseProductVersion());
		System.out.println(md.getDriverName());
		System.out.println(md.getURL());
		System.out.println(md.getUserName());
	
		System.out.println("");
			c.close();
			System.out.println("Connection closed");
	}
		

}
