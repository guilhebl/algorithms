package com.guilhebl.algo.dp;

/**
 * 
 * https://leetcode.com/problems/edit-distance/
 *
 *
 * e.g
 * 
 * abcd 
 * abcef
 * 
 */
public class EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("a", "b"));
	}
	
	public static int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return 0;
		}
		int w1len = word1.length();
		int w2len = word2.length();
		char[] c1 = word1.toCharArray();
		char[] c2 = word2.toCharArray();
		
		int dp[][] = new int[w1len+1][w2len+1];
		
		int min = 0;
		for (int i = 0; i <= w1len; i++) {
			for (int j = 0; j <= w2len; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					if (c1[i-1] == c2[j-1]) {
						dp[i][j] = dp[i-1][j-1];
					} else {
						min = Math.min(dp[i-1][j], dp[i][j-1]);
						min = Math.min(min, dp[i-1][j-1]);
						dp[i][j] = min + 1;
					}					
				}
			}
		}

		return dp[w1len][w2len];
	}
}
