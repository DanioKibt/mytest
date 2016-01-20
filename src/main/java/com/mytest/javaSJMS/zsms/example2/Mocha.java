package com.mytest.javaSJMS.zsms.example2;

public class Mocha extends CondimentDecorator{

	Drinks drinks;
	
	public Mocha(Drinks drinks){
		this.drinks=drinks;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return this.drinks.getDesc()+",Mocha";
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		return 0.20+this.drinks.count();
	}

	
}
