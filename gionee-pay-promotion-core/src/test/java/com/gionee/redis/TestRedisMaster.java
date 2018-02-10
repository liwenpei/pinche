package com.gionee.redis;
import java.util.List;

import redis.clients.jedis.Jedis;

public class TestRedisMaster {

	private final static String REDIS_PASSWD = "gioneePay$123!paWd";


	public static void main(String[] args) {
		TestRedisMaster t = new TestRedisMaster();

		t.testSetString();
	}


	public void testSetString() {
		Jedis jedis = new Jedis("121.41.108.162", 6379);
		jedis.auth(REDIS_PASSWD);
		System.out.println("Connection to server sucessfully");
		// 设置 redis 字符串数据
		jedis.set("test1", "sunsnow2");
		// 获取存储的数据并输出
		System.out.println("Stored string in redis:: " + jedis.get("test1"));
		jedis.close();
	}

	public void testList() {
		Jedis jedis = new Jedis("121.41.108.162", 6379);
		System.out.println("Connection to server sucessfully");
		// 存储数据到列表中
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		jedis.lpush("tutorial-list", "Mysql2");
		jedis.lpush("tutorial-list", "Mysql3");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}
		jedis.close();
	}
}
