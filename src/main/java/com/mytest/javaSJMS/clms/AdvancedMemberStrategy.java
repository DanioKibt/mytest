package com.mytest.javaSJMS.clms;

/**
 * 各种策略算法类
 * @author cyz
 *
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    public double calcPrice(double booksPrice) {
        
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
