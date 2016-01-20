package com.mytest.DateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	
	
	public String getWeek(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Calendar cal=new GregorianCalendar();
		try {
			Date d=format.parse(date);
			c.setTime(d);
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			System.err.println(c.getTime());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	
	public static void main(String[] args) {
		DateTest dateTest=new DateTest();
		String s=dateTest.getWeek("2015-10-13");
		System.err.println(s);
	}
}
