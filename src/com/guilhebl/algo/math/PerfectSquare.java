package com.guilhebl.algo.math;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 *
 */
public class PerfectSquare {
	
	public static void main(String[] args) {
		for(long i = 0; i <= 16; i++) {
			System.out.println("num - " + i + " : " + isPerfectSquare(i));	
		}
		
		System.out.println(isPerfectSquare(2147483647));
	}
	
    public static boolean isPerfectSquare(long num) {
        long l = 1;
        long h = num;
        long m = 1;
        long n = 0;
        
        while (l <= h) {
            m = (l + h) / 2;
            n = m * m;
            if (n == num) {
                return true;
            }            
            if (n < num) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return false;
    }
}
