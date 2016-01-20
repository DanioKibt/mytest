package com.mytest.javaSJMS.spqmsQ.test2;

/**
 * 适配类：通过创建对象，调用对象内的方法内容进行适配
 * @author cyz
 *
 */
public class Adapter implements Target{

	public void request() {
		Adaptee ae=new Adaptee();
		String s=ae.specialRequest();
		s+="加上的适配内容22222222";
		System.err.println("经过适配的内容："+s);
	}

}
