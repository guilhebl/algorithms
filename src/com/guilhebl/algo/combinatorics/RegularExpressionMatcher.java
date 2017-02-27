package com.guilhebl.algo.combinatorics;

/**
	https://leetcode.com/problems/regular-expression-matching/
 *
 */
public class RegularExpressionMatcher {

	public static void main(String[] args) {		
		System.out.println(isMatch("aa","aa")); // → true
		System.out.println(isMatch("aaa","aa")); // → false
		System.out.println(isMatch("aa", "a*")); // → true		
		System.out.println(isMatch("aa", ".*")); // → true		
		System.out.println(isMatch("ab", ".*")); // → true	
		System.out.println(isMatch("aaa", "a*a")); // → true		
		System.out.println(isMatch("aaa", "ab*a*c*a")); // → true								
		System.out.println(isMatch("aaba", "ab*a*c*a")); // → false				
		System.out.println(isMatch("bbbba", ".*a*a")); // → true		
		System.out.println(isMatch("ab", ".*c")); // → false	
		System.out.println(isMatch("ab", ".*..")); // → true		
		System.out.println(isMatch("abbbcd", "ab*bbbcd")); // → true
		System.out.println(isMatch("bbba", ".*b")); // → false		
		System.out.println(isMatch("aaa", "aaaa")); // → false		
		System.out.println(isMatch("aaaa", "aaa")); // → false
		System.out.println(isMatch("a", "ab*")); // → true
		System.out.println(isMatch("a", "b")); // → false			
		System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")); // → true
		System.out.println(isMatch("a", ".*..a*")); // → false
		System.out.println(isMatch("ab", ".*..c*")); // → true		
		System.out.println(isMatch("", "..*")); // → false				
	}

	public static boolean isMatch(String s, String p) {
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();		
		int sLen = s.length();
		int pLen = p.length();
		
		boolean[][] dp = new boolean[sLen+1][pLen+1];
		dp[0][0] = true;
		
		for (int i = 0; i < pLen; i++) {
		   if (cp[i] == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
		}
		
		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				if (cp[j-1] == cs[i-1] || cp[j-1] == '.') {
					dp[i][j] = dp[i-1][j-1];
				} else if (cp[j-1] == '*') {
					if (j <= 1) {
						dp[i][j] = false;
					} else if (cp[j-2] != cs[i-1] && cp[j-2] != '.') {
						dp[i][j] = dp[i][j-2];
					} else {
	                    dp[i][j] = (dp[i-1][j] || dp[i][j-1] || dp[i][j-2]);
	                }
				}
			}			
		}
		return dp[sLen][pLen];		
	}

}