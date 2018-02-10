package com.carpool.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.carpool.dao.UserDao;
import com.carpool.model.User;

@Component
public class UserDaoImpl implements UserDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(User u) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			conn.createStatement().execute("insert into user values(null,'zhangsan')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete() {
		System.out.println("delete");
	}

}
