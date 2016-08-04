package com.guilhebl.algo.string;

public class PalindromeProbability {

	public static void main(String[] args) {
		solveNumPalindromes();
	}

	public static void solveNumPalindromes() {
		System.out.println(palindromeProbability("haha"));

		System.out.println(palindromeProbability("xxxxy"));

		System.out.println(palindromeProbability("xxxx"));

		System.out.println(palindromeProbability("abcde"));

		System.out.println(palindromeProbability("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhff"));
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