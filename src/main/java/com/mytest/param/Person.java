package com.mytest.param;

import com.sun.istack.internal.logging.Logger;

public class Person extends BaseEntity{
	
	public static Logger logger = Logger.getLogger(Person.class);
	
	private String name;
	private String gender;
	private int age;
	private double weight;
	
	public Person(Long id, String name, String gender, int age, double weight) {
		super();
		this.setId(id);
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
