/*
*算法名称：插入排序
*基本思想： 
    通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

#include<stdio.h>
void insertionSort(int[], int, int);
main(){
    int arr[] = {1, 2, 55, 4, 37, 3, 44, 21, 33, 304 ,45, 16};
	int len = sizeof(arr)/4;
	insertionSort(arr, 0, len - 1); 
	int i;
    for(i = 0 ; i < len; i++){
        printf("%d ", arr[i]);
    }
} 

void insertionSort(int arr[], int left, int right){
    int temp_num, i; 
    for(i = left + 1; i <= right; i++){
    	temp_num = arr[i]; //第一个没排好序的数字
		int j = i - 1;
		while((j >= left) && (arr[j] > temp_num)){
			arr[j + 1] = arr[j];
			j--;
		} 
		arr[j + 1] = temp_num;//j+1即是正确位置 
    }
}
