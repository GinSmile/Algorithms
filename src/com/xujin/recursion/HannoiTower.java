/**
 * 算法名称：汉诺塔问题
 * 算法思想：
 * 1.步骤：
 * 	解法的基本思想是递归。
 * 	假设有n个圆盘，三根柱子，a，b，c，需要把n个盘子（从下往上按照大小顺序摞着）从a柱移动到c柱，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 * 	那么先把A塔顶部的n-1块盘移动到b塔，再把A塔剩下的大盘移到c，最后把b塔的n-1块盘移到c。
 * 	每次移动多于一块盘时，则再次使用上述算法来移动。
 * 2.移动次数
 *  假设移动n个盘子需要移动f(n)次，所以把n-1个盘子移动到b柱子上，需要移动f(n-1)次，然后把第n个盘子移动到c柱子上，需要移动1次，最后把n-1个盘子移动到c柱子上，需要移动f(n-1)次。
 *  综上所述，一共移动了
        f(n) = 2 f(n-1) + 1
    因而，若有n个盘子，则至少需要2^n - 1次移动
 */
package com.xujin.recursion;

import java.util.Scanner;

public class HannoiTower {
	static Scanner reader=new Scanner(System.in);
	public static void main(String...args){
		while(true){
			System.out.println("请输入汉诺塔的盘子总数：");
			int n = reader.nextInt();
			if(n < 1){
				System.out.println("输入的数字必须大于0");
			}
			System.out.println("共需要" + (int)(Math.pow(2, n) - 1) +"次移动：");
			hannoi(n, 'a','b','c');
		}
		
	}
	
	public static void hannoi(int n, char a, char b, char c){
		//把n个盘子从a柱子移动到b柱子   
	    if(n > 0) {  
	        hannoi(n - 1, a, c, b);// 把n-1个盘子移动到c柱子上  
	        move(a, b);  // 把a移动到b   
	        hannoi(n - 1, c, b, a);  // 把第n-1个盘子从c柱子移动到b柱子上  
	    }  
	}

	private static void move(char a, char b) {
		// TODO Auto-generated method stub
		System.out.println(a + "->" + b);
	}
}
