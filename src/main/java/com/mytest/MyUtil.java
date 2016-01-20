package com.mytest;

import java.util.Comparator;

public class MyUtil {

	 public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
	      return binarySearch(x, 0, x.length- 1, key);
	   }

	   // 使用循环实现的二分查找
	   public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
	      int low = 0;//定义最小值位置
	      int high = x.length - 1;//定义数组长度
	      while (low <= high) {//直到最小的大于最大的
	          int mid = (low + high) >>> 1;//逻辑右移，防止数组越界
	          int cmp = comp.compare(x[mid], key);//取出数组中的最中间的元素与关键字做对比
	          if (cmp < 0) {//如果中间元素小于搜索元素
	            low= mid + 1;//最小位置定位到中间元素的下一个元素
	          }
	          else if (cmp > 0) {//如果中间元素大于搜索元素
	            high= mid - 1;//最大位置定位在中间元素的上一个元素位置
	          }
	          else {
	            return mid;//相等的话返回当前位置
	          }
	      }
	      return -1;//查找不到
	   }

	   // 使用递归实现的二分查找
	   private static<T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
	      if(low <= high) {//如果最大位置小于最小位置则不进行以下内容
	        int mid = low + ((high -low) >> 1);//除以2
	        if(key.compareTo(x[mid])== 0) {//比较被搜索关键字是否一致
	           return mid;//一致返回当前元素位置
	        }
	        else if(key.compareTo(x[mid])< 0) {//小于当前元素则将最大位置移动到中间位置的下一个位置
	           return binarySearch(x,low, mid - 1, key);//递归该方法
	        }
	        else {
	           return binarySearch(x,mid + 1, high, key);//小于当前元素则将最大位置移动到中间位置的下一个位置
	        }
	      }
	      return -1;
	   }
}
