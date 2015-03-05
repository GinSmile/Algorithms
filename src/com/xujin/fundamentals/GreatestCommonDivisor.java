/**
 * 算法名称：计算两个非负整数的最大公约数/公倍数
 * 算法思想：   
 *     1.若q是0，则最大公约数为p；否则，计算p和q的余数r，则q和r的最大公约数即为所求。
 *     2.最大公倍数为p和q的乘积与最大公约数的商
 * @version 1.0 2015-03-02
 * @author Gin
 */
package com.xujin.fundamentals;
import java.util.Random;

public class GreatestCommonDivisor {
	public static void main(String...args){
		int p = new Random().nextInt(100);
		int q = new Random().nextInt(100);
		int res = gcd(p, q);
		System.out.println(p + " 和 " + q +"的最大公约数为:" + res);
		System.out.println(p + " 和 " + q +"的最大公倍数为:" + p*q/res);	
	}
	
	public static int gcd(int p, int q){
		if(q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
}
