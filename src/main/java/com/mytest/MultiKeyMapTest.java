package com.mytest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.keyvalue.MultiKey;

import com.google.common.base.Splitter;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.mytest.param.IndicatorType;
import com.sun.istack.internal.logging.Logger;

public class MultiKeyMapTest {
	
	public static Logger logger = Logger.getLogger(MultiKeyMapTest.class);
	
	public static void main(String[] args) {
		double[] score = { 45, 78, 99, 86, 77, 75, 95, 56, 86, 63, 71, 77 };// 得分
		long[] userIds = { 1987, 2213, 9121, 10189, 54242, 93456, 121, 687,
				222, 413, 333, 12 };// 被评用户
		long[] euserIds = { 987, 213, 921, 189, 4242, 3456, 1921, 6897, 2292,
				4123, 3313, 1322 };// 评分用户

		Map<MultiKey, Double> map = new HashMap();
		Map<String, Double> dataMap = new HashMap();
		for (int i = 0; i < score.length; i++) {
			MultiKey multiKeyi = new MultiKey(userIds[i], euserIds[i],
					IndicatorType.ACHIEVEMENT.ordinal());
			//logger.info("===" + multiKeyi);
			// Number[] array = (Number[]);
			//logger.info("---"
					//+ Arrays.asList(multiKeyi.getKeys()).toString());
			map.put(multiKeyi, score[i]);
			dataMap.put(Arrays.asList(multiKeyi.getKeys()).toString(), score[i]);
		}
		
		
		Map<MultiKey, Double> map1 =  getMultiMap(dataMap);
		Set<MultiKey> mkeys = map1.keySet();
		for (MultiKey multiKey : mkeys) {
			logger.info("map----" + map.get(multiKey));
			logger.info("map1---" + map.get(multiKey));
		}
			
	}

	public static<T> Map<MultiKey, T> getMultiMap(Map<String, T> dataMap) {
		Map<MultiKey, T> map = new HashMap();
		Set<String> keys = dataMap.keySet();
		for (String keyStr : keys) {
			// [1,2,3] -> 1,2,3 -> collection
			map.put(getMultiKey(keyStr), dataMap.get(keyStr));
		}
		return map;
	}

	public static MultiKey getMultiKey(String keyStr) {
		// [1,2,3] -> 1,2,3
		keyStr = keyStr.substring(1, keyStr.length() - 1);
		//logger.info("+++1: " + keyStr);
		Splitter splitter = Splitter.on(",").trimResults();
		List<String> keyStrings = splitter.splitToList(keyStr);
		/*for (String string : keyStrings) {
			logger.info(string);
		}*/
		return new MultiKey(Longs.tryParse(keyStrings.get(0)),
				Longs.tryParse(keyStrings.get(1)), Ints.tryParse(keyStrings.get(2)));
	}
}
