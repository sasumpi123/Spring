package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		Emp my = (Emp)factory.getBean("my");
		Emp friend = (Emp)factory.getBean("friend");
		
		
		System.out.println(my);
		System.out.println(friend);
		
	}
}
