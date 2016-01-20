package com.mytest.javaSJMS.spqmsQ.spqms;

/**
 * 实现接口2
 * @author cyz
 *
 */
public class Adapter  extends Source implements Targetable { 
	//继承接口1并且复写method1方法  ，如果不需要对改方法进行复写，不需要实现，父类中已对该方法进行实现  
//	public void method1() {  
//	    }  
	    public void method2() {
	    	System.out.println("复写1");  
	    }
}
