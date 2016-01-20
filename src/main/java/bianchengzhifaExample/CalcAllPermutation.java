package bianchengzhifaExample;

/**
 * 全排列
 * @author cyz
 *
 */
public class CalcAllPermutation {
    
	
	/**
     * 递归实现全排列  
     * @param str 全排列字符串
     * @param st  全排列开始位置
     * @param len 全排列结束位置
     */
    public String calcAllPermutation1(String[] str, int st, int len)  
    {   String s=new String();
        if (st == len - 1)  
        {   
            for (int i = 0; i < len; i ++)  
            {  
            	s+=str[i];
            }  
            s+="  ";
        }  
        else  
        {  
            for (int i = st; i < len; i ++)  
            {  
                swap(str, st, i);  
                s+=calcAllPermutation1(str, st + 1, len);  
                swap(str, st, i);  
            }  
        }  
        return s;
    }  
    public void swap(String[] str, int i, int j)  
    {  
        String temp=new String() ;  
        temp = str[i];  
        str[i] = str[j];  
        str[j] = temp;  
    }
    
    /**
     * 使用笛卡尔积进行全排序
     */
    private static String[] aa = { "aa1", "aa2" };  
    private static String[] bb = { "bb1", "bb2", "bb3" };  
    private static String[] cc = { "cc1", "cc2", "cc3", "cc4" };  
    private static String[][] xyz = { aa, bb, cc };  
    private static int counterIndex = xyz.length - 1;  
    private static int[] counter = { 0, 0, 0 };  
  
    public static void calcAllPermutation2() {  
        counter[counterIndex]++;  
        if (counter[counterIndex] >= xyz[counterIndex].length) {  
            counter[counterIndex] = 0;  
            counterIndex--;  
            if (counterIndex >= 0) {  
            	calcAllPermutation2();  
            }  
            counterIndex = xyz.length - 1;  
        }  
    }  
    
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    	CalcAllPermutation cap=new CalcAllPermutation();
    	String str[] = {"a","b","c"};  
    	System.err.println("---------使用递归实现全排列---------------");
    	String s=cap.calcAllPermutation1(str, 0, str.length); 
    	System.err.println("s:"+s);
    	System.err.println("---------使用笛卡尔积实现全排列---------------");
    	for (int i = 0; i < aa.length * bb.length * cc.length; i++) {  
    	    System.err.print(aa[counter[0]]);  
    	    System.err.print("\t");  
    	    System.err.print(bb[counter[1]]);  
    	    System.err.print("\t");  
    	    System.err.print(cc[counter[2]]);  
    	    System.err.println();  
    	    calcAllPermutation2();  
    	 }  
    }  
}
