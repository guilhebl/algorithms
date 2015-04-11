package com.guilhebl.algo;

/**
 * Find the min. number of perfect squares that sum up to a number N.
 * 
 * @author root
 *
 */
public class MinPerfectSquaresSumUpToN {

	public static void main(String[] args) {
		System.out.println(findMinNumPerfectSquares(2556));
	}
	
	public static int findMinNumPerfectSquares(int n) {
		
		int sqrootOfN = new Double(Math.floor(Math.sqrt(n))).intValue();		
		int squareVal = 0;
		
		int[] t = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			t[i] = i;
		}
		
		for (int i = 2; i <= sqrootOfN; i++) {
			squareVal = i*i;
			for (int j = 2; j <= n; j++) {
				if (squareVal <= j) {					
					t[j] = Math.min(t[j], t[j - squareVal] + 1);					
				}
			}			
		}
														
		return t[n];
	}

}
