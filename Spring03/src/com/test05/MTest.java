package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		Developer dev = (Developer)factory.getBean("honggd");
		Engineer eng = (Engineer)factory.getBean("leess");
		
		System.out.println(dev);
		System.out.println(eng);
	}

}
