package com.khasim.jdbc;
import java.sql.*;
import java.util.List;
public class DBclient {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*EmployeeDao ed=new EmployeeDao();
		int res1=ed.save(new Employee(101,"khasim",166.06));
		int res2=ed.save(new Employee(102,"vali",116.02));
		int res3=ed.save(new Employee(103,"vamsi",108.02));
		int res4=ed.save(new Employee(104,"vinod",216.02));
		System.out.println("Data Inserted Successfully");
		
		Employee emp = EmployeeDao.findById(101);
        System.out.println(emp);
        Employee emp1 = EmployeeDao.findById(102);
        System.out.println(emp1);
        System.out.println("Finded Successfully");
	
		int count = EmployeeDao.deleteById(101);
		if(count == 1) {
		    System.out.println("Deleted successfully");
		} else {
		    System.out.println("No such record found or deletion failed");
		}
		int dcount = EmployeeDao.deleteBySalary(116.02);
        if (dcount > 0) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("No such record found or deletion failed");
        }
        //FindAll
        List<Employee> emps = EmployeeDao.findAll();
        for(Employee x:emps)
        	System.out.println(x.getEmpid()+" "+x.getEmpname()+" "+x.getEmpsalary());*/
       
        //UpdateSalary
		int Update=EmployeeDao.UpdateBySalary(6000.0,200.0);
		if(Update==1)
		System.out.println("Price's are Updated="+Update);
		else
			System.out.println("Price's are Not Updated");
        
		
	}	
	}