package com.test06;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;




public class MyAspect {
	
	@Pointcut("execution(public * *(..))")
	
	public void before(JoinPoint join) {
		System.out.println("출카찍");
	}
	
	public void after(JoinPoint join) {
		System.out.println("고홈");
	}
	
}
