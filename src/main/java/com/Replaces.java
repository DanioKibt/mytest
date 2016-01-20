package com;

import org.apache.commons.lang.StringUtils;


public class Replaces {

	public String replace(String str,String columName){
		str=str.replaceAll("[；;,，]", "、");
		String strs[]=StringUtils.split(str, "、");
		StringBuffer sb=new StringBuffer();
		sb.append("(case ");
		for (String string : strs) {
			String s[]=string.split("-", 2);
			sb.append("when "+columName+"  = '"+s[1]+"' then '"+s[0]+"' ");
		}
		sb.append("end)");
		System.err.println(sb.toString());
		return sb.toString();
	}
	public static void main(String[] args) {
		String str="1-2M光口/电口；2-10M电口,3-100M光口/电口、4-GE光口/电口，5-POS、6-STM-1光口/电口、7-STM-4、8-STM-16、9-STM-64、10-其他";
		Replaces re=new Replaces();
		re.replace(str,"YWLX");
	}
}
