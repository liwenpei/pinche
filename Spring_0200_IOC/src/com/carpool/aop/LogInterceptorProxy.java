package com.carpool.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogInterceptorProxy {
	//@Pointcut("execution(public * com.carpool.dao..*.*(..))")
	public void myMethod(){};
	//@Before("execution(public void com.carpool.dao.impl.UserDaoImpl.save(com.carpool.model.User))")
	//@Before("execution(public * com.carpool.dao..*.*(..))")
	//@Before("myMethod()")
	public void before(){
		System.out.println("method start");
	}
	
	//@AfterReturning("execution(public * com.carpool.dao..*.*(..))")
	//@AfterReturning("myMethod()")
	//@AfterThrowing("execution(public * com.carpool.dao..*.*(..))")
	public void afterReturning(){
		System.out.println("method afterReturning");
	}
	
/*	@Around("execution(public * com.carpool.service..*.add(..))")
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("method around start");
		pjp.proceed();
		System.out.println("method around end");
	}*/
	
}
