package com.mytest;

import java.util.List;

import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.TiesStrategy;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.sun.istack.internal.logging.Logger;

public class RankTest {
	
	public static Logger logger = Logger.getLogger(RankTest.class);
	
	public static void main(String[] args) {
		/*double[] score = { 45, 78, 99, 86, 77, 75, 95, 56, 86, 63, 71, 77 };

		NaturalRanking ranking = new NaturalRanking();
		double[] result = ranking.rank(score);
		 
		logger.info("排名前分数: " + Doubles.asList(score));
		logger.info("排名后名次: " + Doubles.asList(result));
		
		//分数相同策略，打结策略
	    ranking = new NaturalRanking(TiesStrategy.MAXIMUM);
	    result = ranking.rank(score);
	    logger.info("排名后名次: " + Doubles.asList(result));
   
	    ranking = new NaturalRanking(TiesStrategy.MINIMUM);
	    result = ranking.rank(score);
	    logger.info("排名后名次: " + Doubles.asList(result));*/
	    
		double[] score = { 45, 78, 99, 86, 77, 75, 95, 56, 86, 63, 71, 77 };
		
		List<Double> score1  = Lists.transform(Doubles.asList(score), new Function<Double, Double>() {
            public Double apply(Double input) {
                return 0-input;
            }
        });
		
	    //double[] score1 = {-45, -78, -99, -86, -77, -75, -95, -56, -86, -63, -71, -77 };
	    NaturalRanking ranking1 = new NaturalRanking();
		double[] result1 = ranking1.rank(Doubles.toArray(score1));
		 
		logger.info("排名前分数: " + score1);
		logger.info("排名后名次: " + Doubles.asList(result1));
		
		//分数相同策略，打结策略
	    ranking1 = new NaturalRanking(TiesStrategy.MAXIMUM);
	    result1 = ranking1.rank(Doubles.toArray(score1));
	    logger.info("分数相同排名后归后: " + Doubles.asList(result1));
   
	    ranking1 = new NaturalRanking(TiesStrategy.MINIMUM);
	    result1 = ranking1.rank(Doubles.toArray(score1));
	    logger.info("分数相同排名后归前: " + Doubles.asList(result1));
	    
	}
}
