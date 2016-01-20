package com.mytest;

import java.lang.reflect.Method;

/**
 * 字符串大小写转换
 * @author Administrator
 *
 */
public class FSTest {

	 public static void main(String[] args) throws Exception {
	        String str = "hello";
	        System.err.println(str.toUpperCase());
	        Method m = str.getClass().getMethod("toUpperCase");
	        System.err.println(m.invoke(str));  // HELLO
	        
	        String str2 = "HELLO";
	        System.err.println(str2.toLowerCase());
	        Method m2= str.getClass().getMethod("toLowerCase");
	        System.err.println(m2.invoke(str2));  // hello
	        
	    }
}
