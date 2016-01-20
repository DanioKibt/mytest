package com.mytest.test;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class TaskTime implements ServletContextListener{

	private Timer timer=null;
	
public void contextDestroyed(ServletContextEvent arg0) {
	timer.cancel();
	
}

public void contextInitialized(ServletContextEvent arg0) {
	Calendar calendar =Calendar.getInstance();
	calendar.set(calendar.HOUR_OF_DAY, 10);
	calendar.set(calendar.MINUTE, 35);
	calendar.set(calendar.SECOND, 00);
	Date time=calendar.getTime();
	System.err.println("任务启动时间"+time);
    timer=new Timer(true);
	timer.schedule(new ContrackTest(), time, 1000 * 60 * 60 * 24);
	time=calendar.getTime();
	System.err.println("任务执行之后时间"+time);
	
	
}
}
