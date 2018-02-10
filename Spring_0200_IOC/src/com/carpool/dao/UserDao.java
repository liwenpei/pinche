package com.carpool.dao;

import com.carpool.model.User;

public interface UserDao {
	public abstract void save(User u);
	public abstract void delete();
}
