package com.mytest.javaSJMS.gczms.selfExample;

import java.util.Vector;

public class Doll implements Subject{
    
	private Vector<Observer> v=new Vector<Observer>();
	
	private String price;
	
	public Doll(String price){
		this.price=price;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
		notifyObserver();
	}

	public void registerObserver(Observer o) {
		v.add(o);
	}

	public void removeObserver(Observer o) {
		v.remove(v);
	}

	public void notifyObserver() {
		for (Observer o : v) {
			o.update(price);
		}
	}

}
