package com.test05;

public class Developer {
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

	public Developer() {

	}

	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Developer [emp=" + emp + ", dept=" + dept + "]";
	}

}
