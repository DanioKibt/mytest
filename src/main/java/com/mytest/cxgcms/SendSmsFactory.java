package com.mytest.cxgcms;

/**
 * 抽象工厂模式发送短信工厂类
 * @author cyz
 *
 */
public class SendSmsFactory implements Provider{ 

	    public Sender produce() {  
	        return new SmsSender();  
	    }  
}
