/*
*算法名称：插入排序
*基本思想： 
    通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

public class InsertionSort_BinarySearchEdition {
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
			int pos = binarySearch(firstUnsortedNum, sortedArr);
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
	
	
	public static int binarySearch(int key, int[] list){//二分查找，返回key的索引。或者若无key，该key应该在位置（负数）
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

