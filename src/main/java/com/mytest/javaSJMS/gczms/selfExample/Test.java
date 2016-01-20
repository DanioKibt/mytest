package com.mytest.javaSJMS.gczms.selfExample;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Doll d=new Doll("3000");
		Person p1=new Person("张三");
		Person p2=new Person("李四");
		d.registerObserver(p1);
		d.registerObserver(p2);
		System.err.println("-----------------------------");
		d.setPrice("测试11111");
		System.err.println("-----------------------------");
		d.setPrice("测试22222");		

	}

}
