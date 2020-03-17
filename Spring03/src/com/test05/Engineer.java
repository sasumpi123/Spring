package com.test05;

public class Engineer {
	private Emp emp;
	private String dept;
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	
	public Engineer() {
		
	}
	@Override
	public String toString() {
		return "Engineer [emp=" + emp + ", dept=" + dept + "]";
	}
	
	
}
