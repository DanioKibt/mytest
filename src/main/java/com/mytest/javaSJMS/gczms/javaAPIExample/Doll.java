package com.mytest.javaSJMS.gczms.javaAPIExample;

import java.util.Observable;

public class Doll extends Observable{

	private String price;
	
	public Doll(String price){
		this.price=price;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
		this.setChanged();
		this.notifyObservers();
	}
	
	
	
}
