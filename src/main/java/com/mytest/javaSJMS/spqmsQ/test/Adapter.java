package com.mytest.javaSJMS.spqmsQ.test;

/**
 * 适配类：通过实现target的方法，来适配父类中的内容
 * @author cyz
 *
 */
public class Adapter extends Adaptee implements Target{

	public void request() {
		String s=this.specialRequest();
		s+="加上的适配内容22222222";
		System.err.println("经过适配的内容："+s);
	}

}
