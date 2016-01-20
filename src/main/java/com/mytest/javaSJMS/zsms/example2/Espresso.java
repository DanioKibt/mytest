package com.mytest.javaSJMS.zsms.example2;

public class Espresso extends Drinks{

	public Espresso(){
		this.desc="浓咖啡";
	}

	@Override
	public double count() {
		return 1.99;
	}

}
