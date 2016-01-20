package com.mytest.test;

import java.security.MessageDigest;
public class TestMd5 {

public final static String md5(String s) {
	//密文规则
	char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
	try {
		byte[] btInput = s.getBytes();
		// 获得MD5摘要算法的 MessageDigest 对象
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		// 使用指定的字节更新摘要
		mdInst.update(btInput);
		// 获得密文
		byte[] md = mdInst.digest();
		// 把密文转换成十六进制的字符串形式
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		
		return new String(str);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}



public static void main(String[] args) {
	String s=TestMd5.md5("danio");//741CF57FE465C3C45CABB90181940AE9
	                              //741Cg57gE465C3C45CABB90181940AE9
	System.err.println("S::加密后密码："+s);
	
}
}