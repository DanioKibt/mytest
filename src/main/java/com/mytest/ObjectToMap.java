package com.mytest;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public class ObjectToMap {

	
	/**
	 * 转换obj对象为map
	 * 
	 * @param map
	 *            输出的map
	 * @param obj
	 *            被转换的obj,JavaBean转换为Map，Map添加进结果Map
	 * @return 转换好的map
	 */
	private Map<String, Object> beanToMap(Map<String, Object> map, Object obj) {
		if (null == obj && null == map) {
			return map;
		}
		// 判断如果是Map直接存入结果Map返回
		if (obj instanceof Map) {
			for (Iterator it = ((Map) obj).entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				map.put(e.getKey().toString(), e.getValue());
			}
		} else {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					if (null != field.get(obj)) {
						map.put(field.getName(), field.get(obj));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	
}
