package com.khasim.jdbc;

public class Employee {
	private	int empid;
	private	String empname;
	private	Double empsalary;
		
	public Employee(int empid, String empname, Double empsalary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + "]";
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Double getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(Double empsalary) {
		this.empsalary = empsalary;
	}
	
		
}