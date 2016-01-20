package com.mytest;

import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.ranking.NaturalRanking;

import com.google.common.primitives.Doubles;
import com.sun.istack.internal.logging.Logger;

/**
 * 数值数组基本计算
 * 
 * http://commons.apache.org/proper/commons-math/javadocs/api-3.3/index.html
 * @author lifeng
 *
 */
public class StatUtilsTest {
	
	public static Logger logger = Logger.getLogger(StatUtilsTest.class);

	public static void main(String[] args) {
		double[] array = {0.47, 0.1, 0.2, 0.53, 0.47, 0.95 };
		double[] array2 = { 9, 7, 4, 3, 1 ,8 };

		double result1 = StatUtils.product(array);
		logger.info("乘积： " + result1);

		double result2 = StatUtils.sum(array);
		logger.info("求和： " + result2);

		double result3 = StatUtils.sumDifference(array, array2);
		logger.info("差和 sum(sample1[i] - sample2[i])： " + result3);

		double result4 = StatUtils.variance(array2);
		logger.info("方差： " + result4);

		double result5 = StatUtils.mean(array2);
		logger.info("均值： " + result5);

		double result6 = StatUtils.meanDifference(array, array2);
		logger.info("差均值sum(sample1[i] - sample2[i]) / sample1.length： "
				+ result6);

		double result7 = StatUtils.max(array2);
		logger.info("最大值： " + result7);

		double result8 = StatUtils.min(array2);
		logger.info("最小值： " + result8);

		double[] result9 = StatUtils.normalize(array2);
		logger.info("normalize: " + Doubles.asList(result9));

		// 频率
		Frequency count = new Frequency();
		count.addValue(1);
		count.addValue(1);
		count.addValue(1);
		count.addValue(2);
		count.addValue(3);
		logger.info("a的次数： "+count.getCount(1));
		logger.info("b的次数： "+count.getCount(2));
		logger.info("a的频率： "+count.getPct(1));
		logger.info("b的频率： "+count.getPct(2));
		logger.info("频率： "+count.getSumFreq());
		count.addValue(1);
		
		//排名
		NaturalRanking ranking =new  NaturalRanking();
		double[] result10 =ranking.rank(array2);
		logger.info(Doubles.asList(array2) + " 排名: " + Doubles.asList(result10));
		double[] result11 =ranking.rank(array);
		logger.info(Doubles.asList(array) + " 排名: " + Doubles.asList(result11));
		
	}
}
