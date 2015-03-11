/*
*算法名称：插入排序
*基本思想： 
    通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

import java.util.Random;

public class InsertionSort {
	public static void main(String...args){
		//make a random array
		int[] arr = new int[10];
		for(int i=0; i<10; i++){
			arr[i] = new Random().nextInt(100);		
			System.out.print(arr[i] + " ");	
		}
		
		insertionSort(arr);
		
		//print the sorted array
		System.out.println("\n插入排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + " ");
		}
				
		
	}

	private static void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length < 2) return;
		
		int firstUnsortedNum;
		for(int i=1; i<arr.length; i++){
			firstUnsortedNum = arr[i];
			int j = i - 1;
			while(j>=0 && firstUnsortedNum < arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = firstUnsortedNum;
		}
	}
}

