package com.mytest.param;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseEntity {
	
	private Long id;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 覆盖toString方法，目的显示所有JavaBean的属性�?，省略写很多的getXxx的方�?
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		//return ""+this.getId();
	}
}
