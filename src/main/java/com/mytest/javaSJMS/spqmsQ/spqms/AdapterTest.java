package com.mytest.javaSJMS.spqmsQ.spqms;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
 * 目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * @author cyz
 *
 */
public class AdapterTest {
	public static void main(String[] args) {  
        //调用复写后的接口
		Targetable target = new Adapter();  
        //复写内容
        target.method1();  
        target.method2();  
    }  
}
