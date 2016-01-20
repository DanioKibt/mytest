import java.util.ArrayList;
import java.util.List;


public class TestZYZH {
    
	class A{
		private String objId;
		private String name;
		
		public A(String objId,String name){
			this.objId=objId;
			this.name=name;
		}
		public String getObjId() {
			return objId;
		}
		public void setObjId(String objId) {
			this.objId = objId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	List<A> list1=new ArrayList<A>();
	List<A> list2=new ArrayList<A>();
	
	public void zyzhTest(){
		list1.add(new A("0101", "01011"));
		list1.add(new A("0102", "01012"));
		list1.add(new A("0103", "01013"));
		list2.add(new A("0204", "02024"));
		list2.add(new A("0205", "02025"));
		list2.add(new A("0206", "02026"));
	}
	
	public void zyzhpfTest(){
		int rowi=2;
		
	}
	
	public static void main(String[] args) {
		TestZYZH tz=new TestZYZH();
		tz.zyzhTest();
		tz.zyzhpfTest();
	}
}
