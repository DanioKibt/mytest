package com.mytest;

import java.util.List;

import org.assertj.core.util.Lists;

import com.google.common.base.Ascii;
import com.google.common.base.Strings;
import com.sun.istack.internal.logging.Logger;


public class GuavaAsciiTest {
	public static Logger logger = Logger.getLogger(ArrayUtilsTest.class);

	public static void main(String[] args) throws Exception {
		//保留指定长度数据（包含省略替换符号）
		System.err.println("1:"+Ascii.truncate("胡哈市的风景阿萨德飞卡上了东方", 7, "..."));
		
		List<String> s1=Lists.newArrayList();
		s1.add("a");
		s1.add("b");
		List<String> s2=Lists.newArrayList();
		s2.add("a");
		s2.add("c");
		//保留字符串中，相同前缀
		System.err.println("2:"+Strings.commonPrefix("test.test.hhhh", "test.test.dddd"));		
		System.err.println("3:"+Strings.commonPrefix(s1.toString(),s2.toString()));
		
		//相同后缀
		System.err.println("4:"+Strings.commonSuffix("test.test.ddddd", "test.test.dddd"));
		String s="";
		System.err.println("5:"+Strings.emptyToNull(s));
		
		//判空
		System.err.println("6:"+Strings.isNullOrEmpty(s));
		System.err.println("7:"+Strings.nullToEmpty(s));
	}
}
