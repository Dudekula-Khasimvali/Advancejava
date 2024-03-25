package JDBC;
import java.awt.Taskbar.State;
import java.sql.*;
import java.util.*;
public class Transactions {

	public static void main(String[] args) throws SQLException {
		Connection c=null;
		Statement s=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","khasim","welcome");
			s=c.createStatement();
			c.setAutoCommit(false);
			
			s.executeUpdate("insert into emp values(111,khasim,25000.0)");
			s.executeUpdate("insert into emp values(112,'vali',26000.0)");
			s.executeUpdate("insert into emp values(113,'siva',35000.0)");
			
			c.commit();
			System.out.println("Transcation Completed");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("Transaction Failed");
			c.rollback();
			e.printStackTrace();
		}
		finally {
			if(c!=null) {
				c.close();
			}
			if(s!=null) {
				s.close();
			}
		}
	}
}
