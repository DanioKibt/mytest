package com.mytest.cxgcms;

/**
 * 抽象工厂模式邮件发送实现
 * @author cyz
 *
 */
public class MailSender implements Sender {  
   
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  
