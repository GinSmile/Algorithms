/*
*算法名称：选择排序
*基本思想： 
    每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
*时间复杂度：O(n2)
*空间复杂度：O(n) 
*/

#include<stdio.h>
void selectSort(int[], int, int);
int main(){
    int arr[] = {1, 2, 55, 4, 37, 3, 44, 21, 33, 304 ,45, 16};
	int len = sizeof(arr)/4;
	selectSort(arr, 0, len - 1); 
	int i;
    for(i = 0 ; i < len; i++){
        printf("%d ", arr[i]);
    }
} 

void selectSort(int arr[], int left, int right){
	int i,j,temp;
    for(i = 0; i <= right - 1; i++){
    	//i代表已经排好序的个数 
        int small = i;

        //find the most small one to replace the arr[i]
    	for(j = i + 1; j <= right; j++){
    		if(arr[j] < arr[small]){
                small = j;
            }
		} 

        temp = arr[i];
        arr[i] = arr[small];
        arr[small] = temp;
    }
}
