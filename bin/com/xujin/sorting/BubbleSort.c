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

#include<stdio.h>
void bubbleSort(int[], int, int);
void main(){
    int arr[] = {1, 2, 55, 4, 37, 3, 44, 21, 33, 304 ,45, 16};
	int len = sizeof(arr)/4;
	bubbleSort(arr, 0, len - 1); 
	int i;
    for(i = 0 ; i < len; i++){
        printf("%d ", arr[i]);
    }
} 

void bubbleSort(int arr[], int left, int right){
	int i,j,temp;
    for(i = 0; i <= right; i++){
    	//i代表已经排好序（最后面的大数）的个数 
    	for(j = 0; j <= right - i; j++){
    		if(arr[j] > arr[j+1]){
    		//交换
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp; 
		    } 
		} 
    }
}
