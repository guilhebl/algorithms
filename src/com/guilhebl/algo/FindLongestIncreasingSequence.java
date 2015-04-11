package com.guilhebl.algo;

/**
 * Find longest increasing sequence
 * 
 * example:
 * 
 * input: int a[] = {55, 23, 444, 15, 1, 7, 99, 190, 998, 1023, 32, 343};
 * output: 6 --> {1, 7, 99, 190, 998, 1023}
 * 
 * @author root
 *
 */
public class FindLongestIncreasingSequence {

	public static void main(String[] args) {
	
		int a[] = {55, 23, 444, 15, 1, 7, 99, 190, 998, 1023, 32, 343};
		System.out.println(findLIS(a));
	}
	
	public static int findLIS(int a[]) {

		int n = a.length;
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;
	}

}
