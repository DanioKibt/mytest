package com;

import java.util.Arrays;

/**
 * 
 * @author Administrator
 *
 */
interface ProcessorInter {
    String name();

    Object process(Object input);
}

class UpcaseImpl implements ProcessorInter {
    @Override
    
     
    public String name() {
        return this.getClass().getSimpleName();
    }

    
//    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class SplitcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyInter {
	  public static void process(ProcessorInter p , Object input){
	        System.out.println("调用对象名：" + p.name());
	        System.out.println(p.process(input));
	    }

	    public static String s = "BYSocket's Blog is www.bysocket.com";
	    public static void main(String[] args) {
	        process(new UpcaseImpl(),s);
	        process(new SplitcaseImpl(),s);
	    }
}
