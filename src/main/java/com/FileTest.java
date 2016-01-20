package com;

public class FileTest {

	public static void main(String[] args) {
		String s=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.err.println(s);
		s=System.getProperty("user.dir");
		System.err.println(s);
	}
}
