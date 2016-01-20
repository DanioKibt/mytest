package com.mytest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mytest.param.IndicatorType;
import com.sun.istack.internal.logging.Logger;

public class CacheTest {
	public static Logger logger = Logger.getLogger(CacheTest.class);

	public static void main(String[] args) throws Exception {

		// 被评用户-评分用户-指标类型IndicatorType
		long userId = 1987L; // 被评用户
		long euserId1 = 2089L; // 评分用户1
		long euserId2 = 2119L; // 评分用户2
		long euserId3 = 1089L; // 评分用户3

		double score1 = 89.00;
		double score2 = 67.00;
		double score3 = 29.00;

		Map<MultiKey, Double> map = new HashMap();
		MultiKey multiKey1 = new MultiKey(userId, euserId1,
				IndicatorType.ACHIEVEMENT);
		MultiKey multiKey11 = new MultiKey(userId, euserId1,
				IndicatorType.CAPABILITY);
		MultiKey multiKey2 = new MultiKey(userId, euserId2,
				IndicatorType.CAPABILITY);
		MultiKey multiKey3 = new MultiKey(userId, euserId3);

		map.put(multiKey1, score1);
		map.put(multiKey2, score2);
		map.put(multiKey3, score3);
		System.out
				.println(multiKey1.equals(multiKey11) ? "multiKey1: "
						+ multiKey1 : "multiKey1\11: " + multiKey1 + "---"
						+ multiKey11);
		logger.info("multiKey1: " + multiKey11);
		logger.info("multiKey2: " + multiKey2);
		logger.info("multiKey3: " + multiKey3);
		logger.info("test+++++++++++++getKey++++++++++++++++++++++++++++");
		logger.info("test+++++++++++++getKey++++++++++++++++++++++++++++"+multiKey1.getKey(0).toString());
		

		MultiKeyMap<Integer, Double> mkMap1 = new MultiKeyMap();
		mkMap1.put(1, 1,1,1,66.0);
		mkMap1.put(1, 1,1,2,77.0);
		mkMap1.put(1, 1,1,3,88.0);
		mkMap1.put(1, 1,2,1,11.0);
		mkMap1.put(1, 1,2,2,22.0);
		mkMap1.put(1, 1,2,3,33.0);
		
		Set<MultiKey<? extends Integer>> keys = mkMap1.keySet();
		Double xx = mkMap1.get(1, 1,1,1);
		logger.info("xx : "+ xx);

		logger.info("test+++++++++++++multiKeyMap++++++++++++++++++++++++++++");
		MultiKeyMap multiKeyMap=new MultiKeyMap();
		multiKeyMap.put(userId, euserId1, IndicatorType.ACHIEVEMENT, score1);
		multiKeyMap.put(userId, euserId1, IndicatorType.CAPABILITY, score2);
		multiKeyMap.put(userId, euserId2, IndicatorType.ACHIEVEMENT, score1);
		logger.info("test+++++++++++++multiKeyMap++++++++++++++++++++++++++++"+multiKeyMap);
		

		
		//final Double value1 = 5.00;   //项目中的情况是通过页面传过来的值
		// 键值对
		LoadingCache<MultiKey, Double> cahceBuilder = CacheBuilder.newBuilder()
				.build(new CacheLoader<MultiKey, Double>() {
					@Override
					public Double load(MultiKey key) throws Exception {
						//Double value = value1;
						//DecimalFormat df = new DecimalFormat("#.00");
						//String f1 = df.format(new Random().nextDouble()*100);  输出字符串类型
						BigDecimal bg = new BigDecimal(new Random().nextDouble()*100);
				        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  //保留小数点后两位
						Double value =  f1;
						return value;
					}

				});
		// 没有就插入缓存，有则取出value值
		logger.info("multiKey1 value:" + cahceBuilder.get(multiKey1));
		logger.info("multiKey11 value:" + cahceBuilder.get(multiKey11));
		logger.info("multiKey2 value:" + cahceBuilder.get(multiKey2));
		logger.info("multiKey2 value:" + cahceBuilder.get(multiKey3));
		
		
		
	}

}
