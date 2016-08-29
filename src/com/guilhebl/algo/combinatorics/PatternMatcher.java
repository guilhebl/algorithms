package com.guilhebl.algo.combinatorics;

/**
	https://leetcode.com/problems/wildcard-matching/
	https://leetcode.com/problems/regular-expression-matching/
 *
 */
public class PatternMatcher {

	public static void main(String[] args) {
		 System.out.println(isMatch("abc", "..."));
	}

    public static boolean isMatch(String s, String p) {
		if ((s == null || p == null) 
				|| (s.equals("") && !p.equals("") && !p.equals("*"))
				|| (!s.equals("") && p.equals("")))
			return false;
        if (s.equals("") && p.equals("")) return true;

		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		
		int n = s.length();
		int m = p.length();
		
		boolean dp[][] = new boolean[n + 1][m + 1];		
		dp[0][0] = true;		
				
		for (int j = 1; j <= m; j++) {
			if (cp[j-1] == '*') {
				dp[0][j] = dp[0][j-1];					
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (cp[j-1] == '*') {
					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				} else if (cp[j-1] == '?' || cs[i-1] == cp[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
    }
}