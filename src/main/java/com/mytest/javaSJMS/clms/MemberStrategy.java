package com.mytest.javaSJMS.clms;

/**
 * 抽象策略类
 * @author cyz
 *
 */
public interface MemberStrategy {
	 /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
}
