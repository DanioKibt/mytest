package com.mytest.javaSJMS.clms;

/**
 * 策略公共算法整合对象
 * @author cyz
 *
 */
public class Price {
    //持有一个具体的策略对象
    private MemberStrategy strategy;
    /**
     * 构造函数，传入一个具体的策略对象
     * @param strategy    具体的策略对象
     */
    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }
    
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double quote(double booksPrice){
    	booksPrice=booksPrice-10.0;//公共算法
        return this.strategy.calcPrice(booksPrice);
    }
}