import java.util.Date;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class CreateXmlTestByDom4j {

	class testA{
		private String a;
		private String b;
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
		public String getB() {
			return b;
		}
		public void setB(String b) {
			this.b = b;
		}
		
		
	}
	public String createXmlTest(){
		
		testA a=new testA();
		a.setA("a1111");
		a.setB("b2222");
		Document document = DocumentHelper.createDocument();
		document.addComment("1111");//添加注释
		document.addDocType("2222","2222", "2222");//DOCTYPE
		Element root = document.addElement("中调直调电厂定值单下发地调执行");
		root.addAttribute("发送方", "中调OMS");
		root.addAttribute("接收方", "地调OMS");
		root.addAttribute("生成时间", new Date().toString());
		
		Element dataBody = root.addElement("数据体");
		Element dataBody2 = root.addElement("数据体2");
		dataBody2.elementIterator();
		
		Element ywid=dataBody.addElement("业务ID");
		
		ywid.addAttribute("dataType", "1");
		ywid.addAttribute("fieldName", "OBJ_ID");
		dataBody.addElement("编制人");
		dataBody.addElement("编制人");
		dataBody.addElement("编制人");
		return document.asXML();
	}
	
	public static void main(String[] args) {
		CreateXmlTestByDom4j cx=new CreateXmlTestByDom4j();
		String s=cx.createXmlTest();
		System.err.println(s);
	}
}
