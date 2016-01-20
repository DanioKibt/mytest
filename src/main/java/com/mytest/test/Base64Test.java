package com.mytest.test;

import java.io.IOException;

import sun.misc.BASE64Decoder;


public class Base64Test {

//	public static void main(String[] args) {
//		InputStream inputStream=null;
//		File file=new File("D:"+File.separator+File.separator+"test.txt");
//		try {
//			inputStream=new FileInputStream(file);
//			byte[] fileByte=new byte[inputStream.available()];
//			String fileString =new BASE64Encoder().encode(fileByte);
//			System.err.println("fileBase64code:"+fileString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			if(inputStream!=null){
//				try {
//					inputStream.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
//	}
	
	public static void main(String[] args) {
		try {
			byte[] fileByte = new BASE64Decoder().decodeBuffer("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
