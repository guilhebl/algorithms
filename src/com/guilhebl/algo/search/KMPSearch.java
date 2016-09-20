package com.guilhebl.algo.search;

/**
 * 
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 *
 */
public class KMPSearch {

	// Driver program to test above function
	public static void main(String[] args)
	{
	   String t = "ABABDABACDABABCABAB";
	   String p = "ABABCABAB";
	   findIndexesOccurrences(t, p);
	}
	
	// occurrence  
	public static void findIndexesOccurrences(String text, String pattern) {
		
		int n = text.length();
		int m = pattern.length();
		
		int[] lps = computeLPSArray(pattern);
		char[] t = text.toCharArray();
		char[] p = pattern.toCharArray();
		
		int i = 0;
		int j = 0;
		while (i < n) {
			if (t[i] == p[j]) {
				i++;
				j++;
			}
			
			if (j == m) {
				System.out.println("" + (i - j));
				j = lps[j-1];
			}			
			else if (i < n && t[i] != p[j]) {			
				if (j > 0) {
					j = lps[j-1];					
				} else {
					i++;
				}								
			}					
		}
	}

	private static int[] computeLPSArray(String pattern) {
		int len = 0;
		int i = 1;
		int m = pattern.length();
		char[] p = pattern.toCharArray();
		int[] lps = new int[m];
		lps[0] = 0;
		
		while (i < m) {
			if (p[i] == p[len]) {
				len++;
				i++;
			} else {
				if (len > 0) {
					len = lps[len - 1];					
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		
		return lps;
	}
	
}
