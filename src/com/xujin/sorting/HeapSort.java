/*
*算法名称：堆排序
*
*   算法：
*        1，首先将数组构造成一个最大堆
*        2，因为A[0]为最大的，所以交换A[0]和A[n]
*        3，从堆中去掉节点n（通过减小heapSize）
*
*/

package com.xujin.sorting;


public class HeapSort {
	public static void main(String...arg){
		int[] A = {4,1,3,2,16,9,10,14,8,7};
		heapSort(A);
		
		for(int m=0; m<A.length; m++){
			System.out.print(A[m] + ",");
		}
		System.out.println();
	}
	
	
	public static void heapSort(int[] A){
		buildMaxHeap(A);
		int heapSize = A.length;
		for(int i = A.length-1; i>0; i--){
			//exchange A[0] and A[i]
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			heapSize--;
			maxHeapify(A, 0, heapSize);

		}
	}
	
	
	//构造最大堆
	public static void buildMaxHeap(int[] A){
		int heapSize = A.length;
		int i = A.length/2 - 1;//从这里开始，A.length/2+1到最后A.length-1为叶子结点
		for(;i>=0; i--){
			//所有非叶子结点
			maxHeapify(A, i, heapSize);
		}
	}
	
	
	//当以LEFT(i),RIGHT(i)为根的两棵子树都是最大堆的时候，构造以i为根的最大堆。
	public static void maxHeapify(int[] A, int i, int heapSize){
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//find the largest in A[i],A[left],A[right]
		int largest = i;
		if(left < heapSize && A[left] > A[largest]){
			largest = left;
		}
		if(right < heapSize && A[right] > A[largest]){
			largest = right;
		}
		
		if(largest != i){
			//exchange A[i] and A[largest]
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			maxHeapify(A,largest,heapSize);
		}
	
	}
}


