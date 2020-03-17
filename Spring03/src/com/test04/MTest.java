package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test04.Developer;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		Developer dev = (Developer)factory.getBean("leess");
		System.out.println(dev);
		dev = (Developer)factory.getBean("honggd");
		System.out.println(dev);
	}

}
