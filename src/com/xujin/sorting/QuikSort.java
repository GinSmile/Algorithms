/*
*算法名称：快速排序
*基本思想： 
    通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
	然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
*时间复杂度：下界为O(nlogn)，最坏情况为O(n^2)，平均时间复杂度为O(nlogn) 
*空间复杂度：在对序列的操作过程中只需花费常数级的空间，即S(1)，而在递归栈上需要花费最少logn最多n的空间 
*/

package com.xujin.sorting;

import java.util.Random;

public class QuikSort {
	public static void main(String...args){
		//make a random array
		int[] arr = new int[10];
		for(int i=0; i<10; i++){
			arr[i] = new Random().nextInt(100);		
			System.out.print(arr[i] + " ");	
		}
		
		quickSort(arr, 0, arr.length - 1);
		
		//print the sorted array
		System.out.println("\n排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + " ");
		}			
	}
	
	public static void quickSort(int[] arr, int p, int r){
		if (p>=r) return;
		int q = partition(arr, p, r);
		quickSort(arr, p, q - 1);
		quickSort(arr, q + 1, r);
	}
	
	public static int partition(int[] arr, int p, int r){
		int x = arr[r];
		int i = p - 1;//i为已排好的小于x的最后一个
		for(int j=p; j<r; j++){//j为现在要处理的第一个
			if(x >= arr[j]){
				i++;
				//exchange arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		//exchange arr[i+1] and arr[r]
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		
		return i+1;
	}
}
