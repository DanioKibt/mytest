package com.mytest.huidiao;

public class Demo {

	String url="http://localhost:8080/test/";
	public void setOnClick(OnClick onClick){
		System.err.println("111");
		onClick.click(url);
	}
}
