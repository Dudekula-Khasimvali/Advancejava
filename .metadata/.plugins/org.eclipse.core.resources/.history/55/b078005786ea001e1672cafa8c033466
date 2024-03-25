package com.mysql.command;
import java.sql.*;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
public class Resultset_vs_Rowset {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/khasim","root","root");
		
		Statement s=c.createStatement();
		ResultSet set=s.executeQuery("select * from emp");
		CachedRowSet rowset = RowSetProvider.newFactory().createCachedRowSet();
				rowset.populate(set);
				rowset.afterLast();
				while(rowset.previous()) {
					System.out.println(rowset.getInt(1)+" "+rowset.getString(2)+" "+rowset.getFloat(3));
				}
				c.close();
	}
}