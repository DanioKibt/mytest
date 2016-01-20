package com.mytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;

import com.sun.istack.internal.logging.Logger;

public class IOtest {
	
	public static void main(String[] args) throws IOException {
		
		 Logger logger = Logger.getLogger(IOtest.class);
		
		logger.info("------------------文件输出流输出文件---------------------------------------");
		//定义文件名路径
		File f=new File("D:/test/testIOout.txt");
		
			//定义输出流
			OutputStream out =new FileOutputStream(f);
			//转换低级流为高级流
			PrintStream ps=new PrintStream(out);
			String s="test IO output ";
			ps.print(s);
			ps.flush();
			ps.close();
		
		logger.info("------------------文件输出流输出文件---------------------------------------");
		
		
		logger.info("------------------文件输入流读取文件---------------------------------------");
		
		   //获取文件
			InputStream input=new FileInputStream("D:/test/testIOout.txt");
			//将高级流转换为低级流
			Reader r =new InputStreamReader(input);
			//取出相应内容
		    BufferedReader	br=new BufferedReader(r);
		    logger.info("br:"+br.readLine());
		
		logger.info("------------------文件输入流读取文件---------------------------------------");
	}

}
