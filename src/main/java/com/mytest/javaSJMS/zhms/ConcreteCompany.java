package com.mytest.javaSJMS.zhms;

import java.util.ArrayList;
import java.util.List;

/**
 * 继承公司基本属性
 * 创建总公司信息（根）
 * @author cyz
 *
 */
public class ConcreteCompany extends Company {  
    //数据集合
	private List<Company> cList;  
  
	//初始化集合构造函数
    public ConcreteCompany() {  
        cList = new ArrayList<Company>();  
    }  
  
    
    public ConcreteCompany(String name) {  
        super(name);   
        cList = new ArrayList<Company>() ;   
    }  
  
    @Override  
    protected void add(Company company) {  
        cList.add(company);  
    }  
  
    @Override  
    protected void display(int depth) {  
        // TODO Auto-generated method stub  
        StringBuilder sb = new StringBuilder("");  
        for (int i = 0; i < depth; i++) {  
            sb.append("-");   
        }  
        System.out.println(new String(sb) + this.getName());  
        for (Company c : cList) {  
            c.display(depth + 2);  
        }  
    }  
  
    @Override  
    protected void romove(Company company) {  
        cList.remove(company);  
    }  

}
