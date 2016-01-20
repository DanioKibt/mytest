package com.mytest;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.assertj.core.util.Lists;
import org.json.simple.JSONValue;

import com.sun.istack.internal.logging.Logger;

public class ArrayUtilsTest {

	public static Logger logger =Logger.getLogger(ArrayUtilsTest.class);
	public static void main(String[] args) throws Exception {
		List<String> s=Lists.newArrayList();
		s.add("a");
		s.add("b");
		s.add("c");
		ArrayUtils.add(s.toArray(), 1, null);  
		logger.info("s"+s.toString());
		List<Object> s2=Arrays.asList(ArrayUtils.add(s.toArray(), 3, "testa"));
		
		logger.info("s2"+s2);
		
		ArrayUtils.add(s.toArray(), 3, "testb");
		logger.info("s2"+s.toString());
	}
	
	//处理json null object 异常
	public void ex(){
		try {
			Object o=new Object();
			JSONValue.parseWithException(o.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
