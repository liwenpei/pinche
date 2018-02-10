package com.gionee.pay.promotion.dao.cache;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
public interface CacheSao {
	/**获取缓存数据
	 * @param key
	 * @return
	 */
	public String get(String key);
	
	/**设置缓存数据
	 * @param key
	 * @param val
	 */
	public void set(String key,String val);
	
	

	public Object getObject(String key);

	public void setObject(String key, Object val);
}
