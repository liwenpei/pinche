package com.gionee.common.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.gionee.common.constant.CommonConstant;

/**
 * 钱包公共util类
 * 
 * @author dingyw
 *
 *         2015年8月11日
 */
public class CommonUtil {

	public static String getTimeStamp() {
		return ((Long) (System.currentTimeMillis() / 1000)).toString();
	}

	/**
	 * byte数组转换成16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	public static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
	public static int stringToInt(String str){
		int i = 0;
		try{
			i = Integer.parseInt(str);
		}catch(Exception e){}
		
		return i;
	}
	
	public static int bigDecimalToInt(BigDecimal b){
		int i = 0;
		try{
			i=b.intValue(); 
		}catch(Exception e){}
		
		return i;
	}
	
	public static BigDecimal objToBigDecimal(Object obj){
		BigDecimal b = null;
		try{
			b = new BigDecimal(obj.toString());
		}catch(Exception e){}
		return b;
	}
	
	public static BigDecimal stringToBigDecimal(String str){
		BigDecimal b = null;
		try{
			b = new BigDecimal(str);
		}catch(Exception e){}
		return b;
	}
	
	public static String stringWithoutNull(String str){
		if(str == null){
			return "";
		}else{
			return str;
		}
	}


	/**
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public final static String getIpAddress(HttpServletRequest request)
			throws IOException {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");

			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");

			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");

			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");

			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();

			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}

	public static boolean checkDateEqual(Date date) {

		if (date == null) {
			return false;
		}
		try {
			Date curr = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String currDate = sdf.format(curr);
			String targetDate = sdf.format(date);
			if (currDate.equals(targetDate)) {
				return true;
			}

		} catch (Exception e) {
			
		}
		return false;
	}
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}
	
	/**
	* @Title: getUUID 
	* @Description: 获取UUID
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws
	*/
	public static String getUUID() {
	String uuid = UUID.randomUUID().toString(); 
	uuid = uuid.substring(0,8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24); 
	        return uuid;
	}

	/**
	* @Title: getCode 
	* @Description: 随机生成4位验证码
	* @param @return 设定文件 
	* @return String 返回类型 
	* @throws
	*/
	public static String getCode() {
	int i = (int) (Math.random() * 9000 + 1000);
	return i + "";
	}
	
}
