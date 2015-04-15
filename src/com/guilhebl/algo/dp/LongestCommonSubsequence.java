package com.guilhebl.algo.dp;


/**
 * Get get Longest Common Subsequence of 2 integer arrays
 * @author root
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		int a[] = { 16, 44, 55, 1 , 6 , 8 , 9, 88, 26, 110 };
		int b[] = { 27, 76, 88, 0, 55, 99, 94, 70, 7, 9, 110, 67, 102};

		int[] c = getLongestCommonSubsequence(a, b);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i] + " ");
		}
		System.out.println(sb.toString());

	}

	public static int[] getLongestCommonSubsequence(int a[], int b[]) {
		if (a == null || a.length == 0 || b == null || b.length == 0) {
			return null;
		}

		int al = a.length;
		int bl = b.length;
		int[][] m = new int[al + 1][bl + 1];

		for (int i = 0; i <= al; i++) {
			for (int j = 0; j <= bl; j++) {
				if (i == 0 || j == 0) {
					m[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					m[i][j] = 1 + m[i - 1][j - 1];
				} else {
					m[i][j] = Math.max(m[i][j - 1], m[i - 1][j]);
				}
			}
		}

		int longest = m[al][bl];
		int l[] = new int[longest];
		int index = longest;
		int i = al, j = bl;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (a[i - 1] == b[j - 1]) {
				l[index - 1] = a[i - 1]; // Put current character in result
				i--;
				j--;
				index--;
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (m[i - 1][j] > m[i][j - 1])
				i--;
			else
				j--;
		}

		return l;
	}

}