/*
*算法名称：归并排序
*基本思想： 
    采用分治法，将数组分成两部分，两边分别排序，然后把排好序的两个数组合并。
*时间复杂度：O(nlogn)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

import java.util.Random;

public class MergeSort {
	public static void main(String...ages){
		//make a random array
		int[] arr = new int[10];
		for(int i=0; i<10; i++){
			arr[i] = new Random().nextInt(100);		
			System.out.print(arr[i] + " ");	
		}
		
		mergeSort(arr, 0, arr.length - 1);
		
		//print the sorted array
		System.out.println("\n排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + " ");
		}		
	}
	
	public static void merge(int[] arr, int p, int q, int r){
		//分成左右两个数组，左边是p,p+1,...q
		//右边是q+1,q+2,...,r
		int lsize = q - p + 1;
		int rsize = r - q;
		int[] L = new int[lsize + 1]; //加上最后一个哨兵（最大值）
		int[] R = new int[rsize + 1];
		
		for(int i=0; i<lsize; i++){
			L[i] = arr[p + i];
		}
		L[L.length - 1] = 99999;
		for(int j=0; j<rsize; j++){
			R[j] = arr[q + 1 + j];
		}
		R[R.length - 1] = 99999;
		
		int i = 0;
		int j = 0;
		for(int k = p; k<=r; k++){
			if(L[i] <= R[j]) 
				arr[k] = L[i++];			
			else
				arr[k] = R[j++];
		}
		
	}
	
	public static void mergeSort(int[] arr, int p, int r){
		if(p < r){
			int q = (p + r)/2;
			mergeSort(arr, p, q);//p,p+1,...,q
			mergeSort(arr, q + 1, r);//q+1,q+2,...,r
			merge(arr, p, q, r);
		}
	}
	
}
