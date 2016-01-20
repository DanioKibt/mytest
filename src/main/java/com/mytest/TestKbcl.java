package com.mytest;

public class TestKbcl {



    public void print(String... args) {
        for (int i = 0; i < args.length; i++) {
            System.err.print(args[i]+" ");
        }
    }

    public void print(String test) {
    	System.err.println("----------");
    }

    public static void main(String[] args) {
    	TestKbcl test = new TestKbcl();
        test.print("hello");
        test.print("hello", "alexia");
}
}
