/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.project.xxx.common;

public class Common {
	public static boolean objToBoolean(Object obj) {
		boolean rntValue = false;
		try {
			rntValue = Boolean.parseBoolean(obj.toString());
		} catch (Exception e) {
		}

		return rntValue;
	}
	
	public static Integer objToInteger(Object obj) {
		Integer rntValue = 0;
		try {
			rntValue = Integer.parseInt(obj.toString());
		} catch (Exception e) {
		}

		return rntValue;
	}
}