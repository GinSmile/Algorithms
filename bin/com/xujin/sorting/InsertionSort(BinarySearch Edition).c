/*
*算法名称：折半插入排序（引入二分搜索的插入排序） 
*基本思想： 
    通过构建有序序列，对于未排序数据，在已排序序列中从利用二分搜索，找到相应位置并插入。
    相比传统的插入排序减少了比较次数。 
*时间复杂度：O(n2)
*空间复杂度：O(1) 
*/

#include<stdio.h>
#include<math.h>

void insertionSort(int[], int, int);
int binarySearch(int[], int, int, int);

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
		int j = i - 1;//最后一个排好序的数字的索引 
		//利用二分搜索找到正确位置
		int index = binarySearch(arr, temp_num, 0, j);
		index = abs(index);
		//把arr数组中从index到最后一个排好序的数字全部右移一位 
	    for(; j >= index; j--){
	        arr[j + 1] = arr[j];
		}
		arr[index] = temp_num;
    }
}

//二分搜索，找到目标值时返回值为下标，找不到时返回应放置的位置（负数） 
int binarySearch(int arr[], int x, int left, int right){
    if(left > right){
        return -left;
    }
	int mid = left + (right - left)/2;
    if(arr[mid] == x){
        return mid;
    }
    else if(arr[mid] > x){
        return binarySearch(arr, x, left, mid - 1); 
    }
    else if(arr[mid] < x){
        return binarySearch(arr, x, mid + 1, right); 
    }
    
}
