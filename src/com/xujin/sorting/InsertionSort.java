/*
*算法名称：插入排序
*基本思想： 
    通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

public class InsertionSort {
	public static void main(String...args){
		int[] arr = {2,52,87,62,82,62,32,96,31,69};		
		insertionSort(arr);
		System.out.println("\n插入排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + ",");
		}
	}

	private static void insertionSort(int[] arr) {
		if(arr.length < 2) return;
		
		int firstUnsortedNum;//第一个未排序的数，我们认为arr[0]已经排好序，因而从arr[1]开始
		for(int i=1; i<arr.length; i++){
			firstUnsortedNum = arr[i];
			int j = i - 1;
			while(j>=0 && firstUnsortedNum < arr[j]){//和已排好序的数进行比较，从最后一个已排序数开始
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = firstUnsortedNum;
		}
	}
}