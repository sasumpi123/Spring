package com.test02;

public class Address {
	private String name;
	private String addr;
	private String phone;

	public Address() {
		this.name = "임성훈";
		this.addr = "경기도 용인시 기흥구 흥덕4로";
		this.phone = "010-4871-5771";

	}

	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}

	public String toString() {
		return "이름 : " + name + "\t주소 :" + addr + "\t전화번호 : " + phone;
	}
}
