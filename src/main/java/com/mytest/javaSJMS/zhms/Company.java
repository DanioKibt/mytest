package com.mytest.javaSJMS.zhms;

/**
 * 定义父类
 * @author cyz
 *
 */
public abstract class Company {

	 //父类型属性
	 private String name;  
	  
	 //带参数构造函数
	    public Company(String name) {  
	        this.name = name;  
	    }  
	  //不带参数构造函数
	    public Company() {  
	    }  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    //添加抽象方法
	    protected abstract void add(Company company);  
	  
	    //移除抽象方法
	    protected abstract void romove(Company company);  
	  
	    //展示抽象方法
	    protected abstract void display(int depth);  
}
