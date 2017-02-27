package com.guilhebl.algo.dp;

/**
 * 
 * https://leetcode.com/problems/shortest-palindrome/
 *
 */
public class ShortestPalindrome {

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("ab"));
	}

	public static String shortestPalindrome(String s) {
	    int j = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        if (s.charAt(i) == s.charAt(j)) { j += 1; }
	    }
	    if (j == s.length()) { return s; }
	    String suffix = s.substring(j);
	    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}

}