package com.mytest.javaSJMS.zsms.example2;

public class Soy extends CondimentDecorator{

	Drinks drinks;
	
	public Soy(Drinks drinks){
		this.drinks=drinks;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return this.drinks.getDesc()+",Soy";
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		return 0.10+this.drinks.count();
	}
}
