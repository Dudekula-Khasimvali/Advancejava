package com.product.app;
import java.sql.Connection;
import java.util.*;



import java.sql.*;

public class ProductDao {
		
		public static int CreateProductTable() {
			int count=0;
			 try (Connection c = PDConnection.Connection();
		             Statement s = c.createStatement())
			{		        
		        String q = "create table product(pid number(5),pname varchar2(10),price number(10,2))";
	
		        count=s.executeUpdate(q);
		        System.out.println("product table created");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return count;
			}
		
		
	public  int SaveProduct(Product p) {
		
		int count=0;
		try(Connection c=PDConnection.Connection();PreparedStatement ps=c.prepareStatement("insert into product values(?,?,?)"))
			{
				//Set values
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			ps.setDouble(3, p.getPrice());
			//Execute the Dynamic Query
			count=ps.executeUpdate();
			}catch(SQLException s) {
				s.printStackTrace();
			}
		return count;
	}
	public static Product getProductById(int pid) {
		Product p=new Product();
		try(Connection c=PDConnection.Connection();PreparedStatement ps=c.prepareStatement("select * from product where pid=?"))
		{
			//set Input Data
			ps.setInt(1, pid);
			//get Data From DataBase
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				p.setPid(set.getInt(1));
				p.setPname(set.getString(2));
				p.setPrice(set.getDouble(3));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static List<Product> getFindAllProducts(){
		List<Product> pl=new ArrayList<Product>();
		try(Connection c=PDConnection.Connection();Statement s=c.createStatement())
		{
			ResultSet set=s.executeQuery("select * from Product");
			while(set.next()) {
				Product p=new Product();
				p.setPid(set.getInt(1));
				p.setPname(set.getString(2));
				p.setPrice(set.getDouble(3));
				pl.add(p);
			}
			}catch(SQLException s) {
				s.printStackTrace();
			}
		return pl;
		}
	public static int deleteById(int pid) {
		
		int count=0;
		try(Connection c=PDConnection.Connection();PreparedStatement ps=c.prepareStatement("delete from Product where pid=?"))
		{
			ps.setInt(1, pid);
			count=ps.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return count;
	}
	public static int deleteByPrice(Double price) {
		int count=0;
		try(Connection c=PDConnection.Connection();PreparedStatement ps=c.prepareStatement("delete from product where price=?"))
		{
			ps.setDouble(1,price);
			count=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static int UpdateByPrice(Double cprice, Double incprice) {
		int count=0;
		try(Connection c=PDConnection.Connection();PreparedStatement ps=c.prepareStatement("update product set price=price+? where price>?"))
		{
			ps.setDouble(1, cprice);
			ps.setDouble(2, incprice);
			
			count=ps.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return count;
	}
	
	public static int DropTable() {
		
		int count=0;
		try(Connection c=PDConnection.Connection();Statement s=c.createStatement())
		{
			String s1="drop table product";
			count=s.executeUpdate(s1);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	}