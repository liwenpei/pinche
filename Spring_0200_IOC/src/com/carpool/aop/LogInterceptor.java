package com.carpool.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInterceptor  implements InvocationHandler{
	public void beforeMethod(Method method){
		System.out.println(method.getName() + " start");
	}
	
	// 目标对象
	private Object target;
	public void setTarget(Object target){
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		beforeMethod(method);
		// 执行相应的目标方法
		Object rs = method.invoke(target, args);
		return rs;
	}
}
