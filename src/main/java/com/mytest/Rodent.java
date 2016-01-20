package com.mytest;

abstract class Rodent{
	public abstract void apperence();
	}

class Mouse extends Rodent{
	public void apperence(){System.out.println("It runs fast");}
	}

class Gerbil extends Rodent{
	public void apperence(){System.out.println("It's eyes are small");}
	}

class Hamster extends Rodent{
	public void apperence(){System.out.println("It's so big");}
	}
	

	
