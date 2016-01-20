package com.mytest.test;

public class TestStatic extends Context{

	public int goods_num;
	private static TestStatic st;
	public static TestStatic getInstance(){
		return st;
	}
	
	public TestStatic(){
		super();
	}
	
	public TestStatic(Context context){
		super(context);
		st=this;
	}
	public void test(){
		class test2{
			
		}
	}
	
}

