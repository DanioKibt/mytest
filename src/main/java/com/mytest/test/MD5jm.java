package com.mytest.test;

import java.util.Date;

public class MD5jm {

	private static final char code[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
	    'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
	    'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
	    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
	    'U', 'V', 'W', 'X', 'Y', 'Z', ',', '.', '/', ';', '\'', ':', '"',
	    '[', ']', '{', '}', '\\', '|', '!', '@', '#', '$', '%', '^', '&',
	    '*', '(', ')', '-', '_', '+', '=', '0', '1', '2', '3', '4', '5',
	    '6', '7', '8', '9' };
	
	public static void Md5_6(String md5Password){
		
		String testPassWord;
		MD5jm md5=new MD5jm();
		String result;
		for (int a = 0; a < code.length; a++) {
			testPassWord="";
			testPassWord+=code[a];
			for (int b = 0; b < code.length; b++) {
				testPassWord=testPassWord.substring(0,1);
				testPassWord+=code[b];
				for (int c = 0; c < code.length; c++) {
					testPassWord = testPassWord.substring(0, 2);
				      testPassWord += code[c];
				      for (int d = 0; d < code.length; d++) {
				    	  testPassWord = testPassWord.substring(0, 3);
				          testPassWord += code[d];
				          for (int e = 0; e < code.length; e++) {
				        	  testPassWord = testPassWord.substring(0, 4);
				        	  testPassWord += code[e];
				        	  for (int f = 0; f < code.length; f++) {
				        		  testPassWord = testPassWord.substring(0, 5);
				        			           testPassWord += code[f];
				        			           result = TestMd5.md5(testPassWord);
				        			           if (md5Password.equals(result)) {
				        			               System.out.println("密码 已经破解!");
				        			               System.out.println("明文是:" + testPassWord);
				        			               System.out.println("密文是:" + md5Password);
				        			               return;
							}
						}
					}
				}
			}
		}
	}}
		public static void main(String[] args) {
			MD5jm md5Obj = new MD5jm();
			                // MD5加密对象
			   String md5Password = TestMd5.md5(password);
			   // 把这个认为我要找到的经过加密的密码
			   System.out.println("密码破测试中!");
			   System.out.println("明文是:" + password);
			   System.out.println("密文是:" + md5Password);
			   System.out.println("程序时间计时器!");
			   System.out.println("开始时间:" + new Date());
			   Md5_6(md5Password);
			   // 依次调用6位破解到20位破解..
			   // Md5_7(testResult);
			   System.out.println("结束时间:" + new Date());
			}

			private static final String password = "danio1";

			/**
			* 这里只是一个实现的方法, 在自己破解的时候把自己的密文直接贴出来, 
			* 进行破解, 这里只是进行一个aaaBc8加密的测试
			*/
			private static final String MD5PWD = "你的数据库中的密文";
}
