/*
*算法名称：归并排序
*基本思想： 
    采用分治法，将数组分成两部分，两边分别排序，然后把排好序的两个数组合并。
*时间复杂度：O(nlogn)
*空间复杂度：O(n) 
*/

#include<stdio.h>
#define MAX 1000;

void mergeSort(int[], int, int);
void merge(int[], int, int, int);

main(){
    int arr[] = {1, 2, 55, 4, 37, 3, 44, 21, 33, 304 ,45, 16};
	int len = sizeof(arr)/4;
	mergeSort(arr, 0, len - 1); 
	int i;
    for(i = 0 ; i < len; i++){
        printf("%d ", arr[i]);
    }
    getchar();
} 
 
//使arr数组有序 
void mergeSort(int arr[], int left, int right){
    if(left < right){
    	int mid = (right + left)/2;
    	mergeSort(arr, left, mid);//排序左边 
    	mergeSort(arr, mid + 1, right);//排序右边 
    	merge(arr, left, mid, right);//合并 
    }
}

//利用归并排序的思想，使arr数组left至right有序 
void merge(int arr[], int left, int mid ,int right ){
	int arrL[1000], arrR[1000];//辅助数组，最大1000个 
	int i, j;
	int arrLSize = mid - left + 1;
	int arrRSize = right - mid;
	for(i = 0; i < arrLSize; i++){
		arrL[i] = arr[left + i];
	}
	for(j = 0; j < arrRSize; j++){
		arrR[j] = arr[mid + 1 + j];
	}

	i = 0;
	j = 0;
	int k = left;
	while(i < arrLSize && j < arrRSize){
		if(arrL[i] <= arrR[j]){
			arr[k++] = arrL[i++];
		}else{
			arr[k++] = arrR[j++];
		}
	}

    //剩下的直接加到arr 
	while(i < arrLSize){
		arr[k++] = arrL[i++];
	}
	while(j < arrRSize){
		arr[k++] = arrR[j++];
	}

}
