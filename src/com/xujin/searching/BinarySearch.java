/**
 * 算法名称：二分搜索
 * 基本思想： 
 *  1.利用元素间的次序关系，采用分治策略，找到目标值时返回值为下标，找不到时返回应放置的位置（负数）。 
 * 	2.将n个元素分成个数大致相同的两半，取a[n/2]与欲查找的x作比较，
 * 	3.如果x=a[n/2]则找到x，算法终止。
 * 	4.如果x<a[n/2]，则我们只要在数组a的左半部继续搜索x（这里假设数组元素呈升序排列）。
 * 	5.如果x>a[n/2]，则我们只要在数组a的右半部继续搜索x。
 * 时间复杂度：O(log n) 
 * 空间复杂度：O(1) 
 * @version 1.0 2015-03-02
 * @author Gin
 */
package com.xujin.searching;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
	public static void main(String...args){
		//make a random list
		int[] whitelist = new int[10];
		for(int i=0; i<10; i++){
			whitelist[i] = new Random().nextInt(1000);			
		}
		
		//sort the list
		Arrays.sort(whitelist);
		for(int i=0; i<10; i++){
			System.out.print(whitelist[i]+", ");
		}
		
		int key = new Random().nextInt(1000);
		int res = binarySearch(key, whitelist);
		System.out.println("\n二分搜索数字" + key + "，得：" + res);
	}
	
	public static int binarySearch(int key, int[] list){
		int low = 0;
		int high = list.length - 1;
		int middle = 0;
		while(low <= high){
			middle = low + (high - low)/2;
			if(key < list[middle]) high = middle - 1;
			else if(key > list[middle]) low = middle + 1;
			else return middle;
		}
		return low*(-1);
	}
}
