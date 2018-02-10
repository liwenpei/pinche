package com.carpool.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.carpool.aop.CarPoolInvocationHandler;
import com.carpool.aop.LogInterceptor;
import com.carpool.dao.UserDao;
import com.carpool.dao.impl.UserDaoImpl;
import com.carpool.model.User;

public class UserServiceTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService =  (UserService)ctx.getBean("userService");
		User u = new User();
		u.setUserName("000");
		u.setPassword("1111");
		userService.getUserDao().save(u);
        
	}
	
	@Test
	public void testProxy() throws Exception {
		UserDao userDao = new UserDaoImpl();
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDao);
		UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(), new Class[]{UserDao.class}, li);
		userDaoProxy.save(new User());
		userDaoProxy.delete();
	}

}
