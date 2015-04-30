package com.guilhebl.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13634
 * 
 *
 */
public class BuildingTowersEasy {

	public static void main(String[] args) {
		int n = 10;
		int[] x = { 3, 8 };
		int[] t = { 1, 1 };
		System.out.println(maxHeight(n, x, t));

		int n1 = 100000;
		int[] x1 = {};
		int[] t1 = {};
		System.out.println(maxHeight(n1, x1, t1));

		int n2 = 2718;
		int x2[] = { 1, 30, 400, 1300, 2500 };
		int t2[] = { 100000, 100000, 100000, 100000, 100000 };
		System.out.println(maxHeight(n2, x2, t2));

		int n3 = 20;
		int x3[] = { 4, 7, 13, 15, 18 };
		int t3[] = { 3, 8, 1, 17, 16 };
		System.out.println(maxHeight(n3, x3, t3));

		int n4 = 447;
		int x4[] = { 32, 35, 55, 60, 61, 88, 91, 97, 128, 151, 181, 186, 192,
				196, 198, 237, 259, 268, 291, 314, 341, 367, 389, 390, 391,
				428, 435 };
		int t4[] = { 81, 221, 172, 641, 25, 953, 330, 141, 123, 440, 692, 394,
				200, 649, 78, 726, 50, 810, 501, 4, 216, 407, 2, 172, 0, 29, 14 };
		System.out.println(maxHeight(n4, x4, t4));

		int n5 = 97638;
		int x5[] = { 8, 1749, 4550, 5388, 6752, 7089, 9737, 14891, 16671,
				16821, 17691, 19753, 24589, 25348, 30114, 32213, 34376, 36467,
				37699, 41490, 44784, 44893, 57316, 58275, 58567, 61122, 61489,
				63195, 64776, 65905, 68788, 69908, 72853, 78152, 78784, 82779,
				84488, 86277, 88611, 92793, 93214, 97583 };
		int t5[] = { 16610, 6, 497, 14, 42892, 31, 79, 1203, 518, 31147, 597,
				7846, 1396, 8309, 12, 14, 1148, 433, 23693, 13, 1939, 244, 19,
				46, 27, 611, 412, 10, 27023, 19141, 34, 15667, 588, 10, 229,
				83, 390, 14, 38441, 16021, 4, 39386 };
		System.out.println(maxHeight(n5, x5, t5));

	}

	public static int maxHeight(int n, int[] x, int[] t) {
		int max = 0, j = 0, i = 0, limit = 0;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);

		List<Integer> markedOnes = new ArrayList<>();
		for (i = 0; i < x.length; i++) {
			dp[x[i] - 1] = t[i];
			markedOnes.add(x[i] - 1);
		}
		dp[0] = 0;

		for (i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (markedOnes.contains(i)) {
				limit = t[markedOnes.indexOf(i)];
				if (dp[i] > limit) {
					dp[i] = limit;

					j = i - 1;
					while (j > 0 && Math.abs(dp[j] - dp[j + 1]) > 1) {
						dp[j] = dp[j + 1] + 1;
						j--;
					}
				}

			}
		}

		for (i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;
	}

}