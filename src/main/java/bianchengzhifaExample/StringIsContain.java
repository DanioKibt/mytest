package bianchengzhifaExample;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Ordering;

public class StringIsContain {

	/**
	 * 轮询
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean strIsContain1(String a, String b) {
		for (int i = 0; i < b.length(); i++) {
			int j;
			for (j = 0; (j < a.length()) && (a.charAt(j) != b.charAt(i)); j++)
				;
			if (j >= a.length()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 先排序后轮询，降低空间复杂度
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean strIsContain2(String a, String b) {
		a = sortStr(a);
		System.err.println("a:" + a);
		b = sortStr(b);
		System.err.println("b:" + b);
		for (int pa = 0, pb = 0; pb < b.length();) {
			while ((pa < a.length()) && (a.charAt(pa) < b.charAt(pb))) {
				++pa;
			}
			if ((pa >= a.length()) || (a.charAt(pa) > b.charAt(pb))) {
				return false;
			}
			++pb;
		}
		return true;

	}

	/**
	 * 利用List Contains方法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean strIsContain3(String a, String b) {
		List<String> s = new ArrayList<String>();
		for (int i = 0; i < a.length(); i++) {
			String str = String.valueOf(a.charAt(i));
			s.add(str);
		}
		for (int i = 0; i < b.length(); i++) {
			String str = String.valueOf(b.charAt(i));
			if (!s.contains(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 利用素数（缺陷，前16个素数相乘已经超过long的最大范围，因此该方法的使用范围必须在16个不同字母以内）
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean strIsContain4(String a, String b) {
		long p[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
				101 };

		long f = 1;
		for (int i = 0; i < a.length(); i++) {
			long x = p[a.charAt(i) - 'A'];
			if (f % x != 0) {
				f *= x;
			}
		}
		System.err.println("f:" + f);
		for (int i = 0; i < b.length(); i++) {
			long x = p[b.charAt(i) - 'A'];
			if (f % x != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 通过位移判断（根据不同的偏移量来确定是否包含字符）
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean strIsContain5(String a, String b) {
		int hash = 0;
		for (int i = 0; i < a.length(); i++) {
			hash |= (1 << (a.charAt(i) - 'A'));
			System.err.println("hash" + i + ":" + hash);
		}
		for (int i = 0; i < b.length(); i++) {
			if ((hash & (1 << (b.charAt(i) - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}

	private String sortStr(String str) {
		List<String> s = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			String string = String.valueOf(str.charAt(i));
			s.add(string);
		}
		Ordering<String> ordering = Ordering.natural();
		List<String> scoreOrdering = ordering.sortedCopy(s);
		String st = "";
		for (String string : scoreOrdering) {
			st += string;
		}
		return st;
	}

	public static void main(String[] args) {
		String a = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String b = "ASDFGH";
		StringIsContain sic = new StringIsContain();
		System.err.println(sic.strIsContain1(a, b));
		System.err.println(sic.strIsContain2(a, b));
		System.err.println(sic.strIsContain3(a, b));
		System.err.println(sic.strIsContain4(a, b));
		System.err.println(sic.strIsContain5(a, b));

	}
}
