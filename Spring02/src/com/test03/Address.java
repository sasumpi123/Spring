package com.test03;

public class Address {
	private String name;
	private String addr;
	private String phone;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "이름 : " + name + "\t주소 : " + addr + "\t전화번호 : " + phone;
	}
	public Address() {}
}
