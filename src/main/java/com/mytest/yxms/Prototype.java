package com.mytest.yxms;

/**
 * 原型模式原型类
 * @author cyz
 *
 */
public class Prototype implements Cloneable {  

	 public Object clone() throws CloneNotSupportedException {  
	        Prototype proto = (Prototype) super.clone();  
	        return proto;  
	    }  
}
