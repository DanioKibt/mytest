package com.mytest.javaSJMS.spqmsQ.test;

/**
 * 通过接口对父类中的方法进行适配
 * @author cyz
 *
 */
public class Client {

	public static void main(String[] args) {
		Target t=new Adapter();
		t.request();
	}
}
