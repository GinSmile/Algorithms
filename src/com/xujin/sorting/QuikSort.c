/*
*算法名称：快速排序
*基本思想： 
    通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
	然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
*时间复杂度：下界为O(nlogn)，最坏情况为O(n^2)，平均时间复杂度为O(nlogn) 
*空间复杂度：在对序列的操作过程中只需花费常数级的空间，即S(1)，而在递归栈上需要花费最少logn最多n的空间 
*/

#include<stdio.h>

void quikSort(int[], int, int);
int partion(int[], int, int);

main(){
    int arr[] = {1, 2, 55, 4, 37, 3, 32, 44, 21, 33, 304 ,45, 16};
	int len = sizeof(arr)/4;
	quikSort(arr, 0, len - 1); 
	int i;
    for(i = 0 ; i < len; i++){
        printf("%d ", arr[i]);
    }
} 

void quikSort(int arr[], int first, int last){
	if(first < last){
		int mid = partion(arr, first, last);
		quikSort(arr, first, mid - 1);
		quikSort(arr, mid + 1, last); 
	}
	int i;
}

//分区，返回中间索引i，左边的均比arr[i]小，右边均比arr[i]大 
int partion(int arr[], int first, int last){	
	//选最后一个数作为key
	int key = arr[last];
	int i, j, temp;
	i = first - 1;
	//经过以下for循环，arr[0~i]均比key小
	for(j = first; j < last; j++){
		if(arr[j] <= key){
			temp = arr[i + 1];
			arr[i + 1] = arr[j];
			arr[j] = temp;
			i++;
		}
	} 
	
	//交换arr[last]和arr[i + 1]
	temp = arr[i + 1];
	arr[i + 1] = arr[last];
	arr[last] = temp;	
	return i + 1;
}