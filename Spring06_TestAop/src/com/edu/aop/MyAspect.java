package com.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect @Component
public class MyAspect {
	
	
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("도형의 넓이를 구한다.");
	}

	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("도형의 넓이를 출력한다.");
	}
}
