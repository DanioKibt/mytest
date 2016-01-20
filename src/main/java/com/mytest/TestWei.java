package com.mytest;

public class TestWei {

	public static void main(String[] args)   
	{   
	System.out.println("1、以下测试>:");   
	int a = 1, b = 2;   
	System.out.println(a > b);   
	System.out.println("\n2、以下测试>>:");   
	System.out.println("15 >> 2 = " + (15 >> 2));   
	System.out.println("\n3、以下测试>>>:");   
	for (int i = 0; i < 10; i++)   
	{   
	for (int j = 0; j < 10; j = j + 5)   
	{   
	System.out.println(j / (int) (Math.pow(2, i)));   
	System.out.println(j >>> i);   
	}   
	}   
	}  
}
