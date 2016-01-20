package com.StringUtil.copy;



public class Reverse {

	public void ReverseString(char[] s,int from ,int to){
		
		while (from<to) {
			char t=s[from];
			s[from++]=s[to];
			s[to--]=t;
		}
		
		String str="";
		for (int i = 0; i < s.length; i++) {
			str+=s[i];
//			System.err.print(s[i]);
		}
		System.err.println("str:"+str);
		System.err.println("---------------------------");
	}
	
	public void LeftRotateString(char[] s,int n,int m){
		m%=n;
		System.err.println("前m位反转");
		ReverseString(s, 0, m-1);
		System.err.println("每m位反转");
		ReverseString(s, m, n-1);
		System.err.println("前m位移到末端");
		ReverseString(s, 0, n-1);
		
	}
	
	public static void main(String[] args) {
		Reverse r=new Reverse();
		String str="abcdef";
		char[] s=str.toCharArray();
//		r.LeftRotateString(s, 6, 3);
//		r.LeftRotateString(s, 6, 6);
		r.LeftRotateString(s, 6, 3);
//		for (int i = 0; i < s.length; i++) {
//			System.err.println(s[i]);
//		}
	}
}
