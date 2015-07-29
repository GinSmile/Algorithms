/*
*算法名称：冒泡排序
*基本思想： 
    1，比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    2，对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
    3，针对所有的元素重复以上的步骤，除了最后一个。
    4，持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

package com.xujin.sorting;

public class BubbleSort {
	public static void main(String...args){
		int[] arr = {2,52,87,62,82,62,32,96,31,69};	
		bubbleSort(arr);
		System.out.println("\n冒泡排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + ",");
		}	
	}

	private static void bubbleSort(int[] arr) {
		if(arr.length < 2) return;
		
		int right;//每次冒泡那个最大元素落在这个索引位置上
		for(int i=0; i<arr.length-1; i++){//需要进行n-1次冒泡
			right = arr.length - 1 - i;
			for(int j=0; j<right; j++){
				if(arr[j] > arr[j+1]){
					//swap arr[j] and arr[j+1]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

