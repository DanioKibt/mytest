import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class CreateXmlTest {

	public boolean createXmlTest(){
		boolean t=false;
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.newDocument();
			document.setXmlVersion("1.0");
			document.setXmlStandalone(true);
			//
			Element root=document.createElement("自动化厂站定值单");
			//发送方="地调OMS" 接收方="中调OMS" 生成时间=""
			root.setAttribute("发送方","地调OMS");
			root.setAttribute("接收方","中调OMS");
			root.setAttribute("生成时间",new Date().toString());
			document.appendChild(root);
			
			Element dataBody=document.createElement("数据体");
			Element dataBody2=document.createElement("数据体2");
			root.appendChild(dataBody);
			root.appendChild(dataBody2);
			
			for (int i = 0; i < 6; i++) {
				String s="test"+i;
				Element dataBody3=document.createElement(s);
				dataBody.appendChild(dataBody3);
			}
			
			//tableId="" tableName=""
//			dataBody.setAttribute("tableId", "");
//			dataBody.setAttribute("tableName", "");
			
			//querySql
//			Element sqlElem=document.createElement("querySql");
//			sqlElem.setTextContent("asdfasd");
//			dataBody.appendChild(sqlElem);
//			Element ielmen1=document.createElement("1");
//			Element ielmen2=document.createElement("1");
//			dataBody.appendChild(ielmen1);
//			dataBody.appendChild(ielmen2);
//			StringBuffer sql=new StringBuffer();
//			sql.append("SELECT OBJ_ID ");
//			for (int i = 0; i < 5; i++) {
//				Element ielmen=document.createElement(""+i);
//				dataBody.appendChild(ielmen);
//				sql.append(" , "+i);
//			}
//			sql.append(" FROM 表名 WHERE OBJ_ID = ? ");
//			sqlElem.setTextContent(sql.toString());
			
			
			
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			DOMSource domSource=new DOMSource(document);
			
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			transformer.transform(domSource, new StreamResult(bos));
			
			File file=new File("D://catalog.xml");
			if(!file.exists()){
				file.createNewFile();
			}
			FileOutputStream out=new FileOutputStream(file);
			StreamResult xmlResult=new StreamResult(out);
			transformer.transform(domSource, xmlResult);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return t;
	}
	
	public static void main(String[] args) {
		CreateXmlTest cxt=new CreateXmlTest();
		cxt.createXmlTest();
	}
}
