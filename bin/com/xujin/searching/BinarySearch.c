/*
*算法名称：二分搜索
*基本思想： 
    利用元素间的次序关系，采用分治策略，找到目标值时返回值为下标，找不到时返回应放置的位置（负数）。 
	将n个元素分成个数大致相同的两半，取a[n/2]与欲查找的x作比较，
	如果x=a[n/2]则找到x，算法终止。
	如果x<a[n/2]，则我们只要在数组a的左半部继续搜索x（这里假设数组元素呈升序排列）。
	如果x>a[n/2]，则我们只要在数组a的右半部继续搜索x。
*时间复杂度：O(log n) 
*空间复杂度：O(1) 
*/

#include<stdio.h>
int binarySearch(int[], int, int, int);
main(){
    int arr[] = {1, 2, 3, 4 ,5, 6};
    int x;
    printf("please input the number you want to find:"); 
    while(scanf("%d", &x)){
    	int index = binarySearch(arr, x, 0, sizeof(arr) - 1); 
        printf("The index is %d\n", index); 
        printf("please input the number you want to find:");
    }
} 

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