package com.mytest.huidiao;

import java.util.Date;

public class Boss  implements CallBackInterface {  
      
    public void execute() {  
        System.out.println("收到了！！" + new Date());  
          
    }  
}  