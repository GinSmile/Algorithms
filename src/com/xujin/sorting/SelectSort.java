package com.xujin.sorting;

import java.util.Random;

/*
*算法名称：选择排序
*基本思想： 
    每一趟从待排序的数据元素中选出最小的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

public class SelectSort{
	public static void main(String...args){
		//make a random array
		int[] arr = new int[10];
		for(int i=0; i<10; i++){
			arr[i] = new Random().nextInt(100);		
			System.out.print(arr[i] + " ");	
		}
		
		selectSort(arr);
		
		//print the sorted array
		System.out.println("\n选择排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + " ");
		}
	}
private static void selectSort(int[] arr) {
		// TODO Auto-generated method stub
		int i;//i代表已经排好序的个数 
		for(i=0; i<=arr.length-1; i++){
			//找到arr[i]到最后的最小值的索引smallest
			int smallest = i;
			for(int j =i; j<=arr.length-1; j++){
				if(arr[j] < arr[smallest]){
					smallest = j;
				}
			}
			//交换arr[smallest]和arr[i]
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
		}
	}
}
