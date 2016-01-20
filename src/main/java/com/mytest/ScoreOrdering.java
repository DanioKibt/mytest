package com.mytest;

import java.util.List;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;
import com.sun.istack.internal.logging.Logger;

/**
 * 分数排名 NaN: Not a Number
 * 
 * @author kakaka
 *
 */
public class ScoreOrdering {
	
	public static Logger logger = Logger.getLogger(ScoreOrdering.class);
	
	public static void main(String[] args) {
		double[] score = { 45, 78, 99, 86, 77, 75, 95, 56, 86, 63, 71, 77 };

		// 自然排序，数字按大小，日期按先后排序
		Ordering<Double> ordering = Ordering.natural();
		List<Double> scoreOrdering = ordering.sortedCopy(Doubles.asList(score));
		logger.info("分数排序(由小到大)： " + scoreOrdering);
		
		Ordering<Double>  reOrdering = Ordering.natural().reverse();
		List<Double> scoreOrdering1 = reOrdering.sortedCopy(Doubles.asList(score));
		logger.info("分数排序(由大到小)： " + scoreOrdering1);
		
		
		/*
		 * NaturalRanking ranking = new NaturalRanking(); double[] result =
		 * ranking.rank(score);
		 * 
		 * logger.info("排名前分数: " + Doubles.asList(score));
		 * logger.info("排名后名次: " + Doubles.asList(result));
		 * 
		 * // 分数相同的排名处理，可以做名次舍入处理，java.math.RoundingMode List<Double> ranks =
		 * Doubles.asList(result);
		 * 
		 * // RoundingMode.UP 排名归大，归后（归下） List<Integer> rankUp =
		 * Lists.transform(ranks, new Function<Double, Integer>() { public
		 * Integer apply(Double input) { return DoubleMath.roundToInt(input,
		 * RoundingMode.UP); } }); logger.info("排名后名次处理（归后）： " + rankUp);
		 * 
		 * // RoundingMode.DOWN 排名归小，归前（归上） List<Integer> rankDown =
		 * Lists.transform(ranks, new Function<Double, Integer>() { public
		 * Integer apply(Double input) { return DoubleMath.roundToInt(input,
		 * RoundingMode.DOWN); } }); logger.info("排名后名次处理（归前）： " +
		 * rankDown);
		 */

	}
}
