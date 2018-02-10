package com.gionee.pay.promotion.dao.cache.impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gionee.pay.promotion.dao.cache.CacheSao;

/**
 * 缓存sao接口
 * @author dingyw
 *
 * 2016年7月27日
 */
@Service
public class RedisCacheSaoImpl implements CacheSao{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * redis连接
	 */
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		return stringRedisTemplate.opsForValue().get(key);
	}

	@Override
	public void set(String key, String val) {
		stringRedisTemplate.opsForValue().set(key, val); 
	}

	@Override
	public Object getObject(String key) {
		Object obj = null;
		try {
			obj = redisTemplate.opsForValue().get(key);
		} catch (Exception e) {
			log.info(e.getMessage(),e);
		}
		return obj;
	}

	@Override
	public void setObject(String key, Object val) {
		try{
			redisTemplate.opsForValue().set(key, val);
		}catch(Exception e){
			log.info(e.getMessage(),e);
		}
		 
	}
}
