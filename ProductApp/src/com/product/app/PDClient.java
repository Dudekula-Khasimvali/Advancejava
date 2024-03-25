package com.product.app;
import java.sql.*;
import java.util.*;
public class PDClient {

	public static void main(String[] args) {
		Product p=new Product();
		int count=ProductDao.CreateProductTable();
		System.out.println("Table Created Successfully="+count);
	
		//Save Method
		ProductDao pd=new ProductDao();
		int res=pd.SaveProduct(new Product(111,"mobile",25000.0));
		int res1=pd.SaveProduct(new Product(112,"Ac",35000.0));
		int res2=pd.SaveProduct(new Product(113,"TV",5000.0));
		int res3=pd.SaveProduct(new Product(114,"BOOK",2000.0));
		int res4=pd.SaveProduct(new Product(115,"LAPTOP",40000.0));
		System.out.println("Product Values Are Inserted Successfully");

		//FindById
		Product p1=ProductDao.getProductById(111);
		System.out.println(p);
		Product p2=ProductDao.getProductById(112);
		System.out.println(p2);
		Product p3=ProductDao.getProductById(113);
		System.out.println(p3);
		
		//DeleteById
		int count1=ProductDao.deleteById(114);
		System.out.println("Successfully Deleted="+count1);
		
		//DeleteBYPrice
		int count2=ProductDao.deleteByPrice(5000.0);
		System.out.println("Successfully Deleted="+count2);
		//Finding All recrds
		List<Product> pl=ProductDao.getFindAllProducts();
				/*for(Product p:pl)
					System.out.println(p);*/
			pl.forEach(p4->System.out.println(p4));
		
		//Update by Price
			int Update=ProductDao.UpdateByPrice(6000.0,50000.0);
			System.out.println("Price's are Updated="+Update);
		
			//Drop Table
			int drop=ProductDao.DropTable();
			System.out.println("Table Was Droped=");
					
	}

}
