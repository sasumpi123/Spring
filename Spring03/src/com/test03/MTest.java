package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		Developer dev = (Developer)factory.getBean("hong");
		
		System.out.println(dev);
		dev = (Developer)factory.getBean("lee");
		System.out.println(dev);
	}

}
