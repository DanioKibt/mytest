package com.mytest;

public class TestRodent {
	public static void main(String[] args) {
		Rodent[] r={new Mouse(),new Gerbil(),new Hamster()};
		for(Rodent i:r)
		i.apperence();
		}
}
