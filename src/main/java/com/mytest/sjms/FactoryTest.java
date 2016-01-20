package com.mytest.sjms;

public class FactoryTest {

	/**
	 * 普通工厂模式
	 */
//	  public static void main(String[] args) {  
//	        SendFactory factory = new SendFactory();  
//	        Sender sender = factory.produce("sms");  
//	        sender.Send();  
//	    }  
	  
	/**
	 * 多个工厂模式
	 * @param args
	 */
//	  public static void main(String[] args) {  
//	        SendFactory factory = new SendFactory();  
//	        Sender sender = factory.produceMail();  
//	        sender.Send();  
//	    }
	
	  /**
	   * 静态工厂模式
	   * @param args
	   */
	   public static void main(String[] args) {      
	        Sender sender = SendFactory.produceMail();  
	        sender.Send();  
	    }  
}
