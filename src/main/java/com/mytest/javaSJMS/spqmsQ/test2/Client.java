package com.mytest.javaSJMS.spqmsQ.test2;

/**
 * 对象适配器：通过重新创建对象，通过对象内的方法来进行适配
 * @author cyz
 *
 */
public class Client {

	public static void main(String[] args) {
		Target t=new Adapter();
		t.request();
	}
}
