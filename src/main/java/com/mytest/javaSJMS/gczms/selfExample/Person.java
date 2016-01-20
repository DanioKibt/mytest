package com.mytest.javaSJMS.gczms.selfExample;
public class Person implements Observer{

	private String name;
	
	public Person(String name){
		this.name=name;
	}
	
	public void update(String price) {

		System.err.println(name+"测试传入参数"+price);
	}

}
