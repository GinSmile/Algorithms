package com.xujin.sorting;

/*
*算法名称：选择排序
*基本思想： 
    每一趟从待排序的数据元素中选出最小的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

public class SelectSort{
	public static void main(String...args){
		int[] arr = {2,52,87,62,82,62,32,96,31,69};	
		selectSort(arr);
		
		//print the sorted array
		System.out.println("\n选择排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + ",");
		}
	}
	
	private static void selectSort(int[] arr) {
		int i;//i代表已经排好序的个数 
		for(i=0; i<=arr.length-1; i++){
			//找到arr[i]到最后的所有数中的最小值，其索引为smallest
			int smallestIndex = i;
			for(int j =i; j<=arr.length-1; j++){
				if(arr[j] < arr[smallestIndex]){
					smallestIndex = j;
				}
			}
			//交换arr[smallestIndex]和arr[i]
			int temp = arr[smallestIndex];
			arr[smallestIndex] = arr[i];
			arr[i] = temp;
		}
	}
}
