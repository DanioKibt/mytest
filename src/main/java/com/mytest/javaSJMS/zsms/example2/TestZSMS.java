package com.mytest.javaSJMS.zsms.example2;

public class TestZSMS {

	public static void main(String[] args) {
		Drinks d=new Espresso();
		System.err.println(d.getDesc()+" $"+d.count());
		
		Drinks d2=new Decaf();
		d2=new Soy(d2);
		d2=new Whip(d2);
		System.err.println(d2.getDesc()+" $"+d2.count());
	}
}
