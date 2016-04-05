package com.company.auth.client.model;

public class Employee {

	private String empno;
	private String empname;
	
	public Employee(){
		
	}
	public Employee(String empno,String empname){
		this.empno=empno;
		this.empname=empname;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + "]";
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
}
