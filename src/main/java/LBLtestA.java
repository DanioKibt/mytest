
public class LBLtestA {

	private int x=3;
	
	public void Method(int m){
		final int n=x+2;
		class B{
			private int y = 5;  
            
            public void Method2(){  
                System.out.println("y = "+y);  
                System.out.println("n = "+n);  
                //System.out.println("m = "+m);//访问m不允许  
                System.out.println("x = " +x);  
            }  
		}
		B b = new B();//在方法内创建内嵌类的对象  
		b.Method2();//调用内嵌类的方法  
	}
	
	public static void main(String[] args) {  
		LBLtestA a = new LBLtestA();  
        a.Method(6);  
    }  
}
