package com.khasim.jdbc;
import java.sql.*;
import java.util.*;

public class EmployeeDao {
	public int save(Employee emp) {
		Connection c=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//get connection
			c=DBconnection.createConnection();
			ps=c.prepareStatement("insert into emp values(?,?,?)");
			//set inputs
			ps.setInt(1,emp.getEmpid());
			ps.setString(2, emp.getEmpname());
			ps.setDouble(3, emp.getEmpsalary());
			//execute Query
			count=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(c!=null)
				c.close();
			if(ps!=null)
				ps.close();
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		}
		return count;
	}
	public static Employee findById(int empid) {
		Employee employee=null;
		try(Connection c=DBconnection.createConnection();PreparedStatement ps=c.prepareStatement("select * from emp where empid=?"))
		{
			//insert the questionMark
			ps.setInt(1, empid);
			//execute the query
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				employee=new Employee();
				employee.setEmpid(set.getInt(1));
				employee.setEmpname(set.getString(2));
				employee.setEmpsalary(set.getDouble(3));
				
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return employee;
}
public static int deleteById(int empid) {
	int count=0;
	try(Connection c=DBconnection.createConnection();PreparedStatement ps=c.prepareStatement("delete from emp where empid=?"))
	{
		ps.setInt(1, empid);
		count=ps.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return count;
		
}
public static int deleteBySalary(Double empsalary) {
	int dcount=0;
	try(Connection c=DBconnection.createConnection();PreparedStatement ps=c.prepareStatement("delete from emp where empsalary=?"))
	{
		ps.setDouble(1, empsalary);
		dcount=ps.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return dcount;
}
public static List<Employee> findAll(){
	List<Employee> emps=new ArrayList<Employee>();
	try(Connection c=DBconnection.createConnection();Statement s=c.createStatement())
	{
		ResultSet set=s.executeQuery("select * from emp");
		while(set.next()) {
			Employee emp=new Employee();
			emp.setEmpid(set.getInt(1));
			emp.setEmpname(set.getString(2));
			emp.setEmpsalary(set.getDouble(3));
			emps.add(emp);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return emps;	
	}

public static int UpdateBySalary(Double csalary, Double incsalary) {
	int count=0;
	try(Connection c=DBconnection.createConnection();PreparedStatement ps=c.prepareStatement("update emp set empsalary=empsalary+? where empsalary>?"))
	{
		ps.setDouble(1, csalary);
		ps.setDouble(2, incsalary);
		
		count=ps.executeUpdate();
	}catch(SQLException s) {
		s.printStackTrace();
	}
	return count;
}
}