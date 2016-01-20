package com.mytest.javaSJMS.zsms.example2;

public class Whip extends CondimentDecorator{

	Drinks drinks;
	
	public Whip(Drinks drinks){
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
		return 0.15+this.drinks.count();
	}
}
