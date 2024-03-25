package JDBC;
import java.sql.*;

class ConnectionDemo{
	public static Connection connection() {
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","khasim","welcome");
	
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
class Methods{
	public static int tablecreate() {
		int count=0;
		try(Connection c=ConnectionDemo.connection();Statement st=c.createStatement())
		{
			String q="create table student(id number,name varchar2(10),sub varchar(10))";
			count=st.executeUpdate(q);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
public static int save(Student s) {
	int count=0;
	try(Connection c=ConnectionDemo.connection();PreparedStatement ps=c.prepareStatement("insert into student values(?,?,?)"))
	{
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getSub());
		
		count=ps.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return count;
}
public static Student findbyId(int id) {
	Student s=null;
	try(Connection c=ConnectionDemo.connection();PreparedStatement ps=c.prepareStatement("select * from student where id=?")){
		ps.setInt(1, id);
		ResultSet set=ps.executeQuery();
		while(set.next()) {
			s=new Student();
			s.setId(set.getInt(1));
			s.setName(set.getString(2));
			s.setSub(set.getString(3));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return s;
}
public static Student findByName(String name) {
	Student s=null;
	try(Connection c=ConnectionDemo.connection();PreparedStatement ps=c.prepareStatement("select * from student where name=?")){
		ps.setString(1, name);
		ResultSet set=ps.executeQuery();
		while(set.next()) {
			s=new Student();
			s.setId(set.getInt(1));
			s.setName(set.getString(2));
			s.setSub(set.getString(3));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return s;
}
public static int UpdatebyId(int cid,int inid) {
	int count=0;
	try(Connection c=ConnectionDemo.connection();PreparedStatement ps=c.prepareStatement("update student set id=? where id=?")){
		ps.setInt(1, cid);
		ps.setInt(2, inid);
		count=ps.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return count;
}
public static int deletebyName(String name) {
	int count=0;
	try(Connection c=ConnectionDemo.connection();PreparedStatement ps=c.prepareStatement("delete from student where name=?")){
		ps.setString(1, name);
		count=ps.executeUpdate();
		
}catch(SQLException s) {
	s.printStackTrace();
}
	return count;

}
public static int delete() {
	int count=0;
	try(Connection c=ConnectionDemo.connection();Statement ps=c.createStatement()){
		String q="drop table student";
		count=ps.executeUpdate(q);
}catch (Exception e) {
	e.printStackTrace();
}
	return count;
}
}
public class JdbcMethods {

	public static void main(String[] args) {
		
		/*int count=Methods.tablecreate();
		System.out.println("table created Successfully="+count);
		
		Methods m=new Methods();
		int res=m.save(new Student(101,"khasim","java"));
		int res1=m.save(new Student(102,"cali","developer"));
		int res2=m.save(new Student(103,"vali","oracle"));
		System.out.println("Values Inserted Successfully");*/
		
		Student s1=Methods.findbyId(103);
		System.out.println(s1);
		
		Student s2=Methods.findByName("khasim");
		System.out.println(s2);
		
		int count1=Methods.UpdatebyId(101, 105);
		System.out.println(count1);
		
		int count2=Methods.deletebyName("khasim");
		System.out.println(count2);
		
		int c=Methods.delete();
		System.out.println(c);
	}
	
}