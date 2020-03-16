package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address my = (Address) factory.getBean("my");
		Address friend01 = (Address) factory.getBean("friend01");
		Address friend02 = (Address) factory.getBean("friend02");
		
		
		System.out.println(my);
		System.out.println(friend01);
		System.out.println(friend02);
		
	}

}
