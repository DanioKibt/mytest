package com.mytest;

import java.math.BigDecimal;

public class Testmain {
public static void main(String[] args) {
//	Integer f1=new Integer(100);
//	Integer f2=new Integer(100);
//	Integer f3=new Integer(150);
//	Integer f4=new Integer(150);
//	
//	System.err.println(f1==f2);
//	System.err.println(f3==f4);
//	
//	 Double d1=1.0;
//	 Double d2=1.0;
//     System.out.println(d1==d2);
     
     
//     System.err.println("------------------------------------------");
//     String hello = "Hello", lo = "lo";
//     
//     System.err.print((hello == "Hello") + " ");
//
//     System.err.print((Other.hello == hello) + " ");
//
//     System.err.print((hello == ("Hel"+"lo")) + " ");
//
//     System.err.print((hello == ("Hel"+lo)) + " ");
//     
//     System.err.println(hello == ("Hel"+lo).intern());
//     
//     System.err.println("------------------------------------------");	
	
//	String a = "ab";
//	String bb = "b";
//	String b = "a" + bb;
//	System.out.println((a == b)); 
//	
//	String a2 = "ab";
//	final String bb2 = "b";
//	String b2 = "a" + bb2;
//	System.out.println((a2 == b2)); 
	
	double b=100.1-50;
	System.err.println(b);
	
	System.err.println("----------------------------------");
	 BigDecimal   b1   =   new   BigDecimal(100.1);  
     BigDecimal   b2   =   new   BigDecimal(50);  
     System.err.println(b1.subtract(b2).doubleValue());  
     
     BigDecimal   b3   =   new   BigDecimal(Double.toString(100.1));  
     BigDecimal   b4   =   new   BigDecimal(Double.toString(50));
     System.err.println(b1.subtract(b2).doubleValue()); 
}
}

//class Other { static String hello = "Hello"; }