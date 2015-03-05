/**
 * 算法名称：数组内部的几种算法
 * 算法思想：   
 *     1.计算最大值
 *     2.平均值
 *     3.反转数组
 * @version 1.0 2015-03-03
 * @author Gin
 */
package com.xujin.fundamentals;

import java.util.Random;

public class ArrayAlgorithms {
	public static void main(String...args){
		//make a random list
		int[] whitelist = new int[10];
		for(int i=0; i<10; i++){
			whitelist[i] = new Random().nextInt(1000);	
			System.out.print(whitelist[i]+", ");
		}
		
		System.out.println("\n最大值：" + maxValue(whitelist));
		System.out.println("平均值：" + averageValue(whitelist));
		
		//reverse the array
		reverse(whitelist);
		for(int i=0; i<10; i++){
			System.out.print(whitelist[i]+", ");
		}
		
	}
	
	public static int maxValue(int[] list){
		int max = list[0];
		int N = list.length;
		for(int i=1; i<N; i++){
			if(max < list[i]) max = list[i];
		}
		return max;
	}
	
	public static int averageValue(int[] list){
		int total = list[0];
		int N = list.length;
		for(int i=1; i<N; i++){
			total += list[i];
		}
		return total/N;	
	}
	
	public static void reverse(int[] list){
		int N = list.length;
		for(int i=0; i<N/2; i++){
			int temp = list[i];
			list[i] = list[N-i-1];
			list[N-i-1] = temp;
		}
	}
}