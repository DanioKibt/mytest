package com.mytest.javaSJMS.gczms.javaAPIExample;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer{

	private String name;
	
	public Person(String name){
		this.name=name;
	}
	
	public void update(Observable o, Object arg) {
		if(o instanceof Doll){
			Doll doll=(Doll)o;
			System.err.println(name+"测试观察者对象"+doll.getPrice());
		}
		
	}

}
