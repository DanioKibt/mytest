package com.mytest.jsontest;

import net.sf.json.JSONObject;

/**
 * json字符串抛null object 异常处理方式
 * @author Administrator
 *
 */

public class JsonNullObjectTest {

	public static void main(String[] args) {
		try {
			/*当接受到的json参数中出现“：null”的情况时，在进行字符串转换为JSONObject对象之后，
			页面上对该JSONObject进行解析时会出现null object的问题，
			如下：str为接受到的json字符串，将str转换为JSONObject对象，并将该JSONObject对象直接通过mvc传送到jsp页面，
			这样jsp页面会出现null object异常错误*/
			String str="{'sendguid':null,'receiveguid':'2121', 'obj_id':'sdsd', 'endpoint':'fgg', 'lineIDs':'fgfgh'}";
			JSONObject jsonResult = JSONObject.fromObject(str);
			
			/*加入这个异常处理之后，null object异常得到解决*/
            //JSONValue.parseWithException(jsonResult.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
