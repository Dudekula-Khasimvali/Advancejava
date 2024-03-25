package JDBC;
import java.sql.*;

public class JdbcFirstApp {

    public static void main(String[] args) throws Exception {
        // load Driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded Successfully");
        
        // Step-2 Create Connection
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "khasim", "welcome");
        System.out.println("Connection was Created Successfully");
        
        // Step-3 Create table
        Statement s = c.createStatement();
        String q1 = "create table emp(empid number(5),empname varchar2(10),empsalary number(10,2))";
        
        //Statement s1 = c.createStatement();
       // String q3 = "create table product(pid number(5),pname varchar2(10),price number(10,2))";
        
        int res1 = s.executeUpdate(q1);
        System.out.println("Table created Successfully=" + res1);
        
       // int res3=s.executeUpdate(q3);
        //System.out.println("product table created");
        
       String q2="drop table emp";
        int res2=s.executeUpdate(q2);
        // Step-4 close the connection
        c.close();
        System.out.println("Connection closed Successfully");
        
    }
}
