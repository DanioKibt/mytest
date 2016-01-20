package com.backCall;

public class TestBackCall {

	public int i=5;
	public void testBackCall(){
		int count=i;
		if(count==0){
			System.err.println("结束！");
		}else{
			System.err.println("第"+i+"个");
			i--;
			this.testBackCall();
		}
	}
	
	public static void main(String[] args) {
		TestBackCall tbc=new TestBackCall();
		tbc.testBackCall();
	}
}
