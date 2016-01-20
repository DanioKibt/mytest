package com;

public class TestExp {

//	public static void main(String[] args) {
//		double a=-15.958;
//		double b=Math.exp(a);
//		System.err.println(b*8640);
//	}
	
	
//	 public static void main(String[] args) {
//	        StringObject sb = new StringObject();
//	        sb.setName("123");
//	        change(sb);
//	        System.out.println(sb.getName());
//	    }
//
//	    public static void change(StringObject sb) {
//	        sb = new StringObject();
//	        sb.setName("456");
//	    }
	 public static void main(String[] args) {
	        String str = "123";
	        change(str);
	        System.out.println(str);
	    }

	    public static void change(String str) {
	        str = "456";
	    }
	    
	  
}
class StringObject {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}