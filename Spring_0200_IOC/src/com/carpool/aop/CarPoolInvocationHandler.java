package com.carpool.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarPoolInvocationHandler implements InvocationHandler {
	// 目标对象
	private Object target;

	public CarPoolInvocationHandler(Object target){
        this.target = target;
    }

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("------插入前置通知代码-------------");
		// 执行相应的目标方法
		Object rs = method.invoke(target, args);
		System.out.println("------插入后置处理代码-------------");
		return rs;
	}

}
