package com.mytest.javaSJMS.spqmsQ.test2;

/**
 * 被适配类
 * @author cyz
 *
 */
public class Adaptee {

	public String specialRequest(){
		String s="测试1++++++";
		System.err.println("未经过适配的内容："+s);
		return s;
	}
	
}
