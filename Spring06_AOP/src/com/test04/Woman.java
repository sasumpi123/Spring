package com.test04;

public class Woman implements Person{

	@Override
	public String classWork() {
		System.out.println("컴퓨터 켜서 쇼핑");
		return "신발";
	}

}
