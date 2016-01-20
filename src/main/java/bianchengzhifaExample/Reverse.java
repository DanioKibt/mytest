package bianchengzhifaExample;

/**
 * 将字符串前m位移到字符串的第n位之后
 * @author cyz
 *
 */

public class Reverse {

	
	/**
	 * 逐字位移
	 * @param s  
	 * @param n   字符串长度
	 * @param m   需反转字符串长度
	 * @return
	 */
	public String LeftRotateString1(char[] s,int n ,int m){
		while (m-->0) {
			LeftShiftOne(s,n);
		}
		String str="";
		for (int i = 0; i < s.length; i++) {
			str+=s[i];
		}
		return str;
	}
	public void LeftShiftOne(char[] s,int n){
		char t=s[0];
		for (int i = 1; i < n; i++) {
			s[i-1]=s[i];
		}
		s[n-1]=t;
	}
	
	
	/**
	 * 三步反转（使用时该方法时n一定要大于m）
	 * @param s  
	 * @param n   被反转字符串位置
	 * @param m   需反转字符串长度
	 */
	public String LeftRotateString2(char[] s,int n,int m){
		m%=n;
		ReverseString(s, 0, m-1);
		ReverseString(s, m, n-1);
		ReverseString(s, 0, n-1);
		String str="";
		for (int i = 0; i < s.length; i++) {
			str+=s[i];
		}
		return str;
	}
	public void ReverseString(char[] s,int from ,int to){
		while (from<to) {
			char t=s[from];
			s[from++]=s[to];
			s[to--]=t;
		}
	}
	
	public static void main(String[] args) {
		Reverse r=new Reverse();
		String str="abcdefghijklmnopq";
		System.err.println("-----------使用逐位反转----------------");
		System.err.println("str反转前:"+str);
		char[] s1=str.toCharArray();
		String str1=r.LeftRotateString2(s1, 2, 1);
//		String str1=r.LeftRotateString1(s1, str.length(), 4);
		System.err.println("str反转后:"+str1);
		System.err.println("-----------使用三步反转----------------");
		System.err.println("str反转前:"+str);
		char[] s2=str.toCharArray();
		String str2=r.LeftRotateString2(s2, 2, 1);//
//		String str2=r.LeftRotateString2(s2, str.length(), 4);
		System.err.println("str反转后:"+str2);
	}
}
