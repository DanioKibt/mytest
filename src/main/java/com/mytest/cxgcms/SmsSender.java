package com.mytest.cxgcms;

/**
 * 抽象工厂模式短信接口实现
 * @author cyz
 *
 */
public class SmsSender implements Sender {  

   public void Send() {  
       System.out.println("this is sms sender!");  
   }  
}
