package com.mytest;

/**
 * 
 * @author Administrator
 *
 */
public class BeanToZD {

	
	
	public static void main(String[] args) {
		String s="userName";
		System.err.println(upperToLower(s));
	}
	
	public static String upperToLower(String str) {

		if (str == null || str.indexOf("_") != -1) {
			return str;
		}

		char[] c = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0, n = c.length; i < n; i++) {
			if (Character.isUpperCase(c[i])) {
				sb.append("_");
				sb.append(Character.toLowerCase(c[i]));
			} else {
				sb.append(c[i]);
			}
		}
		return sb.toString();
	}
}
