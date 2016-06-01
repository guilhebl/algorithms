package com.guilhebl.algo.bit;

/**
 * 
 * https://leetcode.com/problems/counting-bits/
 *
 */
public class CountBitsSet {

	  
	public static void main(String[] args) {
		printArray(5);
	}

	public static void printArray(int n) {
		int r[] = countBits(n);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
	}
	
	public static int[] countBits(int num) {
	    if (num < 0) {
	    	return null;
	    }
	    if (num == 0) {
	    	return new int[] {0};
	    }
	    
		int i = 0;
		int[] r = new int[num + 1];
		r[0] = 0;
	    for (i = 1; i <= num; i++) {
			r[i] = countSetBits(i);
		}
		return r;
	}
	
	public static int countSetBits(int n) {		
		int c = 0;
		while (n > 0) {
			n &= (n-1);
			c++;
		}
		return c;
	}
	
	
}
