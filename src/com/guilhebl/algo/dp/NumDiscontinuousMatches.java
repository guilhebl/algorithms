package com.guilhebl.algo.dp;

/**
Question: Given two strings, find number of discontinuous matches.
Example: “cat”, “catapult”
Output: 3  -- “CATapult”, “CatApulT”, “CAtapulT”
 * @author root
 *
 */
class NumDiscontinuousMatches {

	public static void main(String[] args) {
		System.out.println(findNumDiscontinuousMatches("catapult", "cat"));
	}

	public static int findNumDiscontinuousMatches(String s, String t) {
		if (s == null || s.equals("") || t == null || t.equals("")){
		 return 0;
		}

		int sl = s.length();
		int tl = t.length();

		char[] charsS = s.toCharArray();
		char[] charsT = t.toCharArray();

		int dp[][] = new int[tl+1][sl+1];

		for (int i = 0; i < sl; i++) {
		 dp[0][i] = 1;
		}

		for (int i = 1; i <= tl; i++) {
		 for (int j = 1; j <= sl; j++) {
		   if (charsT[i-1] == charsS[j-1]) {
		      dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
		   } else {
		      dp[i][j] = dp[i][j-1];
		   }
		 }
		}

		return dp[tl][sl];
	}
		
}