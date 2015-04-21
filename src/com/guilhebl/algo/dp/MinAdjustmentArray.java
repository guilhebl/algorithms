package com.guilhebl.algo.dp;

public class MinAdjustmentArray {

	public static void main(String[] args) {
		int a[] = {1,5,10,15,20,25};
		
		System.out.println(adjustArray(a, 2));
	}
	
	public static int adjustArray(int[] a, int target) { 

		int n = a.length; 
		int[][] dp = new int[n][101]; 

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= 100; j++) {

				if (i == 0) {
					dp[i][j] = Math.abs(a[i] - j);
				} else {
					dp[i][j] = 999999; // Some Max Value

					for (int m = 1; m <= 100; m++) {
						if (Math.abs(m - j) > target)
							continue;

						int diff = Math.abs(a[i] - j) + dp[i - 1][m];
						dp[i][j] = Math.min(dp[i][j], diff);
					}
				}
			}
		}

		int minCost = dp[n - 1][1]; 
		for(int i = 2; i <= 100; i ++) { 
			minCost = Math.min(minCost, dp[n - 1][i]); 
		} 

		return minCost; 
	} 
	
}
