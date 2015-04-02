/*
 * LCS，最长公共子序列问题
 * 问题：求字符数组x和y的最长公共子序列
 * 状态转移方程：
 * 		假设，X[m]表示x序列的前n个字符组成的字符数组
 *		当x[i] == y[j]，LCS(X[i],Y[j]) = LCS(X[i-1],Y[j-1]) + x[m];
 *		否则，LCS(X[i],Y[j]) = max(LCS(X[i-1],Y[j]), LCS(X[i],Y[j-1]));
 * 
 * */
package com.xujin.recursion;

public class LCS {
	public static void main(String...args){
		String a ="abcbdaasdb12589";
		String b = "bdcsaqaba12345";
		char[] x = a.toCharArray();
		char[] y = b.toCharArray();
		
		int[][] c = lenghtLCS(x,y);
		int i = x.length,j = y.length;		
		System.out.print("\nLCS:");
		printLCS(c, x, x.length, y.length);
		
	}

	public static void printLCS(int[][] c, char[] x, int i, int j) {
		if(i == 0 || j == 0){
			return;
		}
		
		if(c[i][j] != c[i - 1][j] && c[i][j] != c[i][j - 1]){
			printLCS(c, x, i - 1, j - 1);
			System.out.print(x[i - 1]);
		}else if(c[i][j] == c[i - 1][j]){
			printLCS(c, x, i - 1, j);
		}else{
			printLCS(c, x,i, j - 1);
		}
		
		
	}
	
	public static int[][] lenghtLCS(char[] x, char[] y){
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
