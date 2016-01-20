package com.mytest.param;

/**
 * 指标类型：业绩指标、能力态度指标、综合指标
 * @author lifeng
 *
 */
public enum IndicatorType {
	/** 业绩指标,业绩得分 */
	ACHIEVEMENT("业绩指标", "业绩得分", 0),

	/** 能力态度指标, 能力态度得分 */
	CAPABILITY("能力态度指标", "能力态度得分", 1),

	/** 综合指标, 综合得分 */
	MULTIPLE("综合指标", "综合得分", 2);

	private String value;
	private String value1;
	private int index;

	private IndicatorType(String value, String value1, int index) {
		this.value = value;
		this.value1 = value1;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (IndicatorType c : IndicatorType.values()) {
			if (c.getIndex() == index) {
				return c.value;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
