package com.mytest.cxgcms;

public class Test {

	 public static void main(String[] args) {  
	        //声明调用的工厂接口类型
		    Provider provider = new SendMailFactory();  
	        //通过方法接口与工厂类接口连接
	        Sender sender = provider.produce();  
	        //调用实现方法
	        sender.Send();  
	    }  
}
