package com.guilhebl.algo.string;

import java.util.HashSet;
import java.util.Set;

public class PalindromeProbability {

	public static void main(String[] args) {
		// solveNumDices();
		solveNumPalindromes();
	}

	public static void solveNumPalindromes() {
		System.out.println(palindromeProbability("haha"));

		System.out.println(palindromeProbability("xxxxy"));

		System.out.println(palindromeProbability("xxxx"));

		System.out.println(palindromeProbability("abcde"));

		System.out
				.println(palindromeProbability("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhff"));
	}

	public static void solveNumDices() {
		// System.out.println(getExpectations(1, 2, 1, 5));
		//
		// System.out.println(getExpectations(3, 1, 1, 3));

		// System.out.println(getExpectations(1, 5, 1, 1));

		// System.out.println(getExpectations(2, 6, 50, 30));

		System.out.println(getExpectations(50, 11, 50, 50));

	}

	public static double getExpectations(int a, int b, int c, int d) {
		long minB = c * 1;
		long maxA = a * b;

		if (maxA <= minB) {
			return -1.0;
		} else if (Math.abs(maxA - minB) == 1) {
			return maxA;
		} else if (b == 1) {
			return maxA;
		}

		int[][] dpA = new int[a + 1][b];
		for (int i = 1; i <= a; i++) {
			for (int j = 0; j < b; j++) {
				if (j == 0) {
					dpA[i][j] = dpA[i - 1][b - 1] + 1;
				} else {
					dpA[i][j] = dpA[i][j - 1] + 1;
				}
			}
		}

		double sum = 0.0D;
		Set<Integer> sets = new HashSet<>();
		for (int i = 1; i < dpA.length; i++) {
			for (int j = 0; j < dpA[i].length; j++) {
				if (dpA[i][j] > minB && !sets.contains(dpA[i][j])) {
					sum += dpA[i][j];
					sets.add(dpA[i][j]);
				}
			}
		}

		return new Double(sum / new Double(sets.size()));
	}

	public static double palindromeProbability(String word) {
		int l = word.length();
		int i;
		char[] chars = word.toCharArray();
		int[] num = new int[26];
		int od = 0;

		for (i = 0; i < l; i++) {
			num[chars[i] - 'a']++;
		}

		for (i = 0; i < 26; i++) {
			if (num[i] % 2 > 0) {
				od++;
			}
		}

		if (od != l % 2) {
			return 0;
		}

		double ret = 1;
		if (od > 0) {
			for (i = 0; i < 26; i++) {
				if (num[i] % 2 > 0) {
					ret = num[i] / (double) l;
					num[i]--;
					l--;
					break;
				}
			}
		}

		for (i = 0; i < 26; i++) {
			while (num[i] > 0) {
				ret *= (num[i] - 1) / (double) (l - 1);
				num[i] -= 2;
				l -= 2;
			}
		}
		return ret;
	}

}