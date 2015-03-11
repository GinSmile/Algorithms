/*
*算法名称：插入排序
*基本思想： 
    通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

import java.lang.reflect.Array;
import java.util.Random;

import com.xujin.searching.BinarySearch;

public class InsertionSort_BinarySearchEdition {
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
		//索引i之前的全部是已排好序的数组元素
		for(int i=1; i<arr.length; i++){
			firstUnsortedNum = arr[i];
			
			//截取字数组
			int[] sortedArr = new int[i];
			for(int m=0; m<i; m++){
				sortedArr[m] = arr[m];
			}
			
			//用二分搜索找到arr[i]应该在什么位置
			int pos = BinarySearch.binarySearch(firstUnsortedNum, sortedArr);
			pos = Math.abs(pos);
			
			//把所有比firstUnsortedNum大的数全部右移一位
			int j = i-1;
			while(j>=pos){
				arr[j+1] = arr[j];
				j--;
			}
			arr[pos] = firstUnsortedNum;
		}
	}
}

