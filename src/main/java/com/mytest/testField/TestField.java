package com.mytest.testField;

import java.lang.reflect.Field;

public class TestField {

	private int test1;
	
	private String test2;
	
	private String test3;
	
	private Double test4;

	public TestField(int test1,String test2,String test3,Double test4){
		this.test1=test1;
		this.test2=test2;
		this.test3=test3;
		this.test4=test4;
	}
	
	public TestField(){}
	
	public int getTest1() {
		return test1;
	}

	public void setTest1(int test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public String getTest3() {
		return test3;
	}

	public void setTest3(String test3) {
		this.test3 = test3;
	}

	public Double getTest4() {
		return test4;
	}

	public void setTest4(Double test4) {
		this.test4 = test4;
	}
	
//	private Map<String, Object> beanToMap(Map<String, Object> map, Object obj) {
//		if (null == obj && null == map) {
//			return map;
//		}
//		// 判断如果是Map直接存入结果Map返回
//		if (obj instanceof Map) {
//			for (Iterator it = ((Map) obj).entrySet().iterator(); it.hasNext();) {
//				Map.Entry e = (Map.Entry) it.next();
//				map.put(e.getKey().toString(), e.getValue());
//			}
//		} else {
//			Field[] fields = obj.getClass().getDeclaredFields();
//			for (Field field : fields) {
//				try {
//					field.setAccessible(true);
//					if (null != field.get(obj)) {
//						map.put(field.getName(), field.get(obj));
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return map;
//	}
	
	public static void main(String[] args) {
		Object tf=new TestField(1, "test2", "test3", 12.00);
		try {
			Field[] f=tf.getClass().getDeclaredFields();
			for (Field field : f) {
				field.setAccessible(true);
				if(null!=field.get(tf)){
					System.err.println("fieldName:"+field.getName());
					System.err.println("fieldValue:"+field.get(tf));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
