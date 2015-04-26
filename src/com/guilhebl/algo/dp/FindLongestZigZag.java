package com.guilhebl.algo.dp;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
 *
 */
public class FindLongestZigZag {

	public static void main(String[] args) {
		solveLongestZigZag();
	}

	public static void solveLongestZigZag() {

		int a[] = { 1, 7, 4, 9, 2, 5 };
		System.out.println(longestZigZag(a));

		int a1[] = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(longestZigZag(a1));

		int a2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(longestZigZag(a2));

		int a3[] = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5,
				1000, 32, 32 };
		System.out.println(longestZigZag(a3));

		int a4[] = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947,
				978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52,
				861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308,
				609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(longestZigZag(a4));
	}

	public static int longestZigZag(int[] a) {
		int n = a.length;
		int[][] dp = new int[n][2];

		dp[0][0] = 1;
		dp[0][1] = 1;

		int longest = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
				} else if (a[j] > a[i]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
				}
				longest = Math.max(longest, Math.max(dp[i][0], dp[i][1]));
			}
		}

		return longest;
	}
}
