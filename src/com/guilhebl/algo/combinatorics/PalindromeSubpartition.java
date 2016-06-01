package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * http://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-
 * partition/
 *
 */
public class PalindromeSubpartition {

	public static void main(String[] args) {
		String abc = "niteataaina";
		List<String> result1 = new ArrayList<String>();
		result1 = palindromePartitioning(abc);
		System.out.println(result1);
	}

	public static List<String> palindromePartitioning(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null)
			return result;
		if (s.length() <= 1) {
			result.add(s);
			return result;
		}

		int length = s.length();
		int[][] table = new int[length][length];

		// l is length, i is index of left boundary, j is index of right boundary
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;

				if (s.charAt(i) == s.charAt(j)) {
					if (l == 1 || l == 2) {
						table[i][j] = 1;

					} else {
						table[i][j] = table[i + 1][j - 1];
					}
					if (table[i][j] == 1) {
						result.add(s.substring(i, j + 1));
					}
				} else {
					table[i][j] = 0;
				}
			}
		}

		return result;

	}
}