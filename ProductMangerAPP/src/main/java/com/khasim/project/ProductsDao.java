package com.khasim.project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao{ 
            public static int save(Products p) {
        		
        		int savecount=0;
        		try (Connection c = ProductsUtils.Connection();PreparedStatement ps = c.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,?)");)
        		{	
        			//set inputs
        			ps.setString(1, p.getProId());
                    ps.setString(2, p.getProName());
                    ps.setDouble(3, p.getProPrice());
                    ps.setString(4, p.getProBrand());
                    ps.setString(5, p.getProMadein());
                    ps.setDate(6, p.getProMfgdate());
                    ps.setDate(7, p.getProExpdate());
                    ps.setBytes(8, p.getProImage());
                    ps.setBytes(9, p.getProAudio());
                    ps.setBytes(10, p.getProVideo());
                    //execute Query
        			savecount=ps.executeUpdate();
        		}
        		catch(SQLException e) {
        			e.printStackTrace();
        		}
        		return savecount;
        	}
public static List<Products> findAll(){
	List<Products> productlist=new ArrayList<Products>();
	try(Connection c=ProductsUtils.Connection();Statement s=c.createStatement())
	{
		ResultSet set=s.executeQuery("select * from product_data");
		while(set.next()) {
			Products p=new Products();
			p.setProId(set.getString("proId"));
			p.setProName(set.getString("proName"));
			p.setProPrice(set.getDouble("proPrice"));
			p.setProBrand(set.getString("proBrand"));
			p.setProMadein(set.getString("proMadein"));
			p.setProMfgdate(set.getDate("proMfgdate"));
			p.setProExpdate(set.getDate("proExpdate"));
			p.setProImage(set.getBytes("proImage"));
			p.setProAudio(set.getBytes("proAudio"));
			p.setProVideo(set.getBytes("proVideo"));
			productlist.add(p);
			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return productlist;	
	}

public static int deleteById(String proId) {
	int count=0;
	try(Connection c=ProductsUtils.Connection();PreparedStatement ps=c.prepareStatement("delete from product_data where proId=?"))
	{
		ps.setString(1, proId);
		count=ps.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return count;
		
}

public static Products findById(String proId) {
	Products product=null;
	try(Connection c=ProductsUtils.Connection();PreparedStatement ps=c.prepareStatement("select * from product_data where proId=?"))
	{
		//insert the questionMark
		ps.setString(1, proId);
		//execute the query
		ResultSet set=ps.executeQuery();
		if(set.next()) {
			product=new Products();
			product.setProId(set.getString(1));
			product.setProName(set.getString(2));
			product.setProPrice(set.getDouble(3));
			product.setProBrand(set.getString(4));
			product.setProMadein(set.getString(5));
			product.setProMfgdate(set.getDate(6));
			product.setProExpdate(set.getDate(7));
			product.setProImage(set.getBytes(8));
			product.setProAudio(set.getBytes(9));
			product.setProVideo(set.getBytes(10));
			
		}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	return product;
}

public static int UpdateById(Products product) {
    String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadein=?, proMfgdate=?, proExpdate=?, proImage=? WHERE proId=?";
    int Updatecount = 0;
    try (Connection c = ProductsUtils.Connection();
            PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setString(1, product.getProName());
        ps.setDouble(2, product.getProPrice());
        ps.setString(3, product.getProBrand());
        ps.setString(4, product.getProMadein());
        ps.setDate(5, product.getProMfgdate());
        ps.setDate(6, product.getProExpdate());
        ps.setBytes(7, product.getProImage());
        ps.setString(8, product.getProId());
        
        Updatecount = ps.executeUpdate();
    } catch (SQLException s) {
        s.printStackTrace();
    }
    return Updatecount;
}
}