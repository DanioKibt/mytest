package com.mytest.jsontest;

import java.util.Map;

import com.sun.istack.internal.logging.Logger;

import flexjson.JSONDeserializer;

/**
 * json反序列化
 * @author Administrator
 *
 */
public class JSONtest {
	
	private static final Logger logger = Logger.getLogger(JSONtest.class);
	
	public static void main(String[] args) {
		String str="{'sendguid':'ddd','receiveguid':'2121', 'obj_id':'sdsd', 'endpoint':'fgg', 'lineIDs':'fgfgh'}";
		Map<String, String> paramMap = (Map<String, String>) new JSONDeserializer<Map<String, String>>()
				.deserialize(str);
		String p_sender=paramMap.get("sendguid");
		String p_guid=paramMap.get("receiveguid");
		String p_funcname=paramMap.get("funcname");
		String p_obj_id=paramMap.get("obj_id");
		String p_endpoint=paramMap.get("endpoint");
		String p_lineIDs=paramMap.get("lineIDs");
		logger.info("p_sender:"+p_sender);
		logger.info("p_guid:"+p_guid);
		logger.info("p_funcname:"+p_funcname);
		logger.info("p_obj_id:"+p_obj_id);
		logger.info("p_endpoint:"+p_endpoint);
		logger.info("p_lineIDs:"+p_lineIDs);
	}
}
