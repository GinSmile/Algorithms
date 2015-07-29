/*
* 算法名称：快速排序
* 基本思想： 
    1. 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小.
	2. 再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列.
* 时间复杂度：下界为O(nlogn)，最坏情况为O(n^2)，平均时间复杂度为O(nlogn) 
* 空间复杂度：在对序列的操作过程中只需花费常数级的空间，即S(1)，而在递归栈上需要花费最少logn最多n的空间 
*/

package com.xujin.sorting;

public class QuikSort {
	public static void main(String...args){
		int[] arr = {2,52,87,62,82,62,32,96,31,69};	
		quickSort(arr, 0, arr.length - 1);
		System.out.println("\n排序后：");
		for(int i=0; i<10; i++){	
			System.out.print(arr[i] + " ");
		}			
	}
	
	public static void quickSort(int[] arr, int left, int right){
		if (left >= right) return;
		int q = partition(arr, left, right);//以arr[q]为界，递归地进行快速排序
		quickSort(arr, left, q - 1);
		quickSort(arr, q + 1, right);
	}
	
	public static int partition(int[] arr, int left, int right){
		int x = arr[right];//取最后一个数作为主元，把整个arr分成小于x和大于x的两部分
		
		int i = left - 1;//i为已排好的数组中，小于x的最后一个
		for(int j = left; j < right; j++){//j为现在要处理的第一个
			if(x >= arr[j]){
				i++;
				//exchange arr[i] and arr[j]
				//即交换当前元素和第一个大于x的元素，这样小于x的元素就都在左边0～i了
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		//exchange arr[i+1] and arr[r]
		int temp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = temp;
		
		return i+1;
	}
}
