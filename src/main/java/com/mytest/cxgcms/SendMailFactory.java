package com.mytest.cxgcms;

/**
 * 抽象工厂模式发送邮件工厂类
 * @author cyz
 *
 */
public class SendMailFactory implements Provider{ 

	    public Sender produce(){  
	        return new MailSender();  
	    }  
}
