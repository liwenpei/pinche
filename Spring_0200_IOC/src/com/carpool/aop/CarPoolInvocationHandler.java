package com.carpool.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarPoolInvocationHandler implements InvocationHandler {
	// Ŀ�����
	private Object target;

	public CarPoolInvocationHandler(Object target){
        this.target = target;
    }

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("------����ǰ��֪ͨ����-------------");
		// ִ����Ӧ��Ŀ�귽��
		Object rs = method.invoke(target, args);
		System.out.println("------������ô������-------------");
		return rs;
	}

}
