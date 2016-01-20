package com.mytest.javaSJMS.clms;

/**
 * 各种策略算法类
 * @author cyz
 *
 */
public class IntermediateMemberStrategy implements MemberStrategy {

    public double calcPrice(double booksPrice) {

        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }

}