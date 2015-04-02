/*
 * LIS，最长递增子序列问题
 * 问题：求字符数组x的最长递增子序列
 * 
 * 这个问题可以转换成字符数组x和排好序的数组x`之间的最长公共子序列的问题
 * x:  1,2,3,44,7,9,12,4,3
 * x`: 1,2,3,3,4,7,9,12,44
 * */
package com.xujin.recursion;

import java.util.Arrays;
import java.util.Random;

public class LIS {
	public static void main(String...args){
		
		//make a random array
		int[] x = new int[30];
		for(int i=0; i<30; i++){
			x[i] = new Random().nextInt(100);		
		}
		int[] x1 = Arrays.copyOf(x, x.length);
		Arrays.sort(x1);
		
		int[][] c = lenghtLCS(x,x1);
		int i = x.length,j = x1.length;
		System.out.print("\nLIS:");
		printLCS(c, x, x.length, x1.length);
		
	}
	
	
	public static void printLCS(int[][] c, int[] x, int i, int j) {
		if(i == 0 || j == 0){
			return;
		}
		
		if(c[i][j] != c[i - 1][j] && c[i][j] != c[i][j - 1]){
			printLCS(c, x, i - 1, j - 1);
			System.out.print(x[i - 1] +",");
		}else if(c[i][j] == c[i - 1][j]){
			printLCS(c, x, i - 1, j);
		}else{
			printLCS(c, x,i, j - 1);
		}
		
		
	}
	
	public static int[][] lenghtLCS(int[] x, int[] y){
		// TODO Auto-generated method stub
		int m = x.length;
		int n = y.length;
		int[][] c = new int[m + 1][n + 1];//保存LCS(Xi,Yj)的长度

		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(x[i] == y[j]){
					c[i + 1][j + 1] = c[i][j] + 1;
				}else{
					if(c[i][j + 1] > c[i + 1][j]){
						c[i + 1][j + 1] = c[i][j + 1];
					}else{
						c[i + 1][j + 1] = c[i + 1][j];
					}
				}
			}
		}
		
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		return c;
		
		
	}
}
