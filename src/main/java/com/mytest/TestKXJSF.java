package com.mytest;

import java.util.regex.Pattern;

/**
 * 使用正则表达式处理科学计数法
 * @author cyz
 *
 */
public class TestKXJSF {

    public boolean isENum(String input){//判断输入字符串是否为科学计数法
//    	String regx = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";//科学计数法正则表达式
    	String regx = "[+-]?[0-9]+.[0-9]+[Ee][+-]?\\d+";
    	Pattern pattern = Pattern.compile(regx);
        return pattern.matcher(input).matches();
    }
    
    public static void main(String[] args) {
    	TestKXJSF tkxjsf=new TestKXJSF();
    	Object s1="cesE";
    	String s2="asdfE2.91E-07";
    	String s4="E2.91E-07asdf";
    	String s3="-22.91E-7";
    	System.err.println("s1:"+tkxjsf.isENum(s1.toString()));
    	System.err.println("s2:"+tkxjsf.isENum(s2));
    	System.err.println("s3:"+tkxjsf.isENum(s3));
    	System.err.println("s4:"+tkxjsf.isENum(s4));
//    	List<String> slist=new ArrayList<String>();
//    	slist.add("cesE");
//    	slist.add("cesE2.91E-07");
//    	slist.add("22.91E-070");
//    	for (String string : slist) {
//			if(tkxjsf.isENum(string)){
//				BigDecimal bd3 = new BigDecimal(string);
//		    	String str3 = bd3.toPlainString();
//		    	System.err.println(string+":"+str3);
//			}
//		}
    	
    	
//    	List<Object> list=new ArrayList<Object>();
//    	list.addAll(slist);
//    	for (Object object : list) {
//    		BigDecimal bd3 = new BigDecimal(object.toString());
//	    	String str3 = bd3.toPlainString();
//	    	System.err.println("test:"+str3);
//		}
    	
//    	BigDecimal bd1 = new BigDecimal(s1.toString());
//    	String str1 = bd1.toPlainString();
////    	BigDecimal bd1 = new BigDecimal(s1);
////    	String str = bd1.toPlainString();
////    	BigDecimal bd2 = new BigDecimal(s2); 
//    	BigDecimal bd3 = new BigDecimal(s3);
//    	String str3 = bd3.toPlainString();
//    	System.err.println(str1);
////    	System.err.println(bd2);
//    	System.err.println(str3);
    	
	}
}
