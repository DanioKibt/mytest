package com.mytest.javaSJMS.zsms.example2;

public abstract class Drinks {

	public String desc="饮料简介";
	
	public String getDesc(){
		return desc;
	}
	
	public abstract double count();
}
