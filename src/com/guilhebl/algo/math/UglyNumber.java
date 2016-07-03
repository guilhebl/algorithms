package com.guilhebl.algo.math;

/**
 * 
 * https://leetcode.com/problems/ugly-number/
 *
 */
public class UglyNumber {
	
	public static void main(String[] args) {

		for (long i = 0; i <= 20; i++) {
			System.out.println(i + " : " + isUgly(i));	
		}
		
	}
	
	public static boolean isUgly(long num) {
		if (num <= 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
			return false;
		}

		long n = 7;
		long m = num / 2;
		
		while (n <= m) {
			if (isPrime(n) && num % n == 0) {
				return false;
			}
			n++;
		}
		
		return true;
	}
	
	public static boolean isPrime(long n) {
		if (n <= 1 || n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for(long i = 5; i * i <= n; i+=6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

}
