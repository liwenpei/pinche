package com.carpool.service;

import org.springframework.stereotype.Component;

import com.carpool.dao.UserDao;

public class UserService {
	private UserDao userDao;
	public UserService(){}
	public void init(){
		System.out.println("init");
	}

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(){
		System.out.println("add");
	}

}
