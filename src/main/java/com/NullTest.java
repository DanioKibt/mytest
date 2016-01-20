package com;

public class NullTest {

	class Atest{
		private int a;
		
		private String b;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}
		
		
	}
	public void TestNull(){
		Atest a=new Atest();
		System.err.println(a.getA());
		System.err.println(a.getB());
		
	}
	public static void main(String[] args) {
	
		NullTest nt=new NullTest();
		nt.TestNull();
	}
}

