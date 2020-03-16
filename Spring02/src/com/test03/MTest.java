package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Address my = (Address)factory.getBean("my");
		Address hong = factory.getBean("hong", Address.class);
		Address self = (Address)factory.getBean("self");
		self.setAddr("우림");
		self.setName("남현우");
		self.setPhone("010-3333-4444");
		
		System.out.println(my);
		System.out.println(hong);
		System.out.println(self);
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
