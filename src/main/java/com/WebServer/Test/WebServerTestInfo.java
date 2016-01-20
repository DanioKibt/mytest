package com.WebServer.Test;

import java.io.ByteArrayInputStream;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.types.Schema;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;





public class WebServerTestInfo {

	public  String invoke(Object[] obj) throws Exception{
		String endpointURL="http://localhost:5148/WebServer/services/receiveMediumAndLongTermOperationModeCountersignInfomationTest";
		String nameSpaceURL="http://oms.gd.soa.csg.cn";
		String soapActionURL="http://schemas.xmlsoap.org/wsdl/soap/";
		String remoteMethod="receiveMediumAndLongTermOperationModeCountersignInfomationTest";
		
		String id="";
		
		Service service=new Service();
		Call call=(Call)service.createCall();
			
		call.addParameter(new QName(nameSpaceURL,"receiveMediumAndLongTermOperationModeCountersignInfomationTestRequest"),org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_SCHEMA);
		call.setUseSOAPAction(true);
		call.setSOAPActionURI(soapActionURL);
		call.setTargetEndpointAddress(new java.net.URL(endpointURL).toString());
		
		QName qname=new QName(nameSpaceURL,remoteMethod);
		call.setOperationName(qname);
		
		Schema schema=(Schema)call.invoke(obj);
		String res=schema.get_any()[1].getAsString();
		
		return res;
	}
	
	public static void main(String[] args) {
		try {
			WebServerTestInfo wsti=new WebServerTestInfo();
			String s=wsti.invoke(new Object[]{"111","QW","1","QW","TEST","TEST","QW","TEST","TEST"});
			SAXReader reader=new SAXReader();
			Document doc=reader.read(new ByteArrayInputStream(s.getBytes()));
			Node node=doc.selectSingleNode("receiveMediumAndLongTermOperationModeCountersignInfomationTestResponse");
			System.err.println("getStringValue():"+node.getStringValue());
			System.err.println("getText():"+node.getText());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
