package com.mytest.huidiao;

public class Main {

	public static void main(String[] args) {
		Demo demo=new Demo();
		demo.setOnClick(new OnClick() {
			
			public void click(String url) {
				System.err.println("123123123123");
				
			}
		});
	}
}
