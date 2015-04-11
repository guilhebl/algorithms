package com.guilhebl.algo;

/**
 * You are given a String of number characters (S), like the following for example:

"132493820173849029382910382"

Now, let's assume we tie letters to numbers in order such that:

A = "0"
B = "1"
C = "2"
...
M = "12"
N = "13"
...
Y = "24"
Z = "25"

Write an algorithm to determine how many strings of letters we can make with S, 
by converting from numbers to letters.

 * @author root
 *
 */
public class FindMaxCombinationStringsInIntegerSeq {

	public static void main(String[] args) {
		System.out.println(countStrings("132493820173849029382910382".toCharArray()));
	}
	
	public static int countStrings(char[] s) {
		return countStrings(s, s.length);
	}

	public static int countStrings(char[] s, int n) {
		if (n < 2) {
			return 1;
		}

		int number = (s[n - 1] - '0') + (s[n - 2] - '0') * 10;

		if ((number >= 10) && (number <= 25)) {
			return 1 + countStrings(s, n - 1) + countStrings(s, n - 2);
		} else {
			return 1 + countStrings(s, n - 1);
		}
	}

}
