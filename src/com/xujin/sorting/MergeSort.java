/*
*算法名称：归并排序
*基本思想： 
    采用分治法，将数组分成两部分，两边分别排序，然后把排好序的两个数组合并。
*时间复杂度：O(nlogn)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

public class MergeSort {
	public static void main(String...ages){
		int[] arr = {2,52,87,62,82,62,32,96,31,69};	
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("\n排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + ",");
		}		
	}
	
	public static void merge(int[] arr, int left, int mid, int right){
		//分成左右两个数组，左边是left,left+1,...mid
		//右边是mid+1,mid+2,...,right
		int lsize = mid - left + 1;
		int rsize = right - mid;
		int[] L = new int[lsize + 1]; //加上最后一个哨兵（最大值）
		int[] R = new int[rsize + 1];
		
		for(int i=0; i<lsize; i++){
			L[i] = arr[left + i];
		}
		L[L.length - 1] = Integer.MAX_VALUE;
		for(int j=0; j<rsize; j++){
			R[j] = arr[mid + 1 + j];
		}
		R[R.length - 1] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for(int k = left; k<=right; k++){
			if(L[i] <= R[j]) 
				arr[k] = L[i++];			
			else
				arr[k] = R[j++];
		}	
	}
	
	public static void mergeSort(int[] arr, int left, int right){
		if(left < right){
			int mid = (left + right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
}
