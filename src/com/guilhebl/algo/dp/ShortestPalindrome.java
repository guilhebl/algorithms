package com.guilhebl.algo.dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/shortest-palindrome/
 *
 */
public class ShortestPalindrome {

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));

		System.out.println(shortestPalindrome("abbacc"));
	}

	public static String shortestPalindrome(String s) {
		if (s == null || s.length() == 0 || isPalindrome(s)) {
			return s;
		}

		Queue<Character> qChars = new LinkedList<>();
		StringBuilder sb = new StringBuilder(s);
		while (sb.length() > 1 && !isPalindrome(sb.toString())) {
			qChars.add(sb.charAt(sb.length() - 1));
			sb = sb.deleteCharAt(sb.length() - 1);
		}
		StringBuilder r = new StringBuilder();

		while (!qChars.isEmpty()) {
			r.append(qChars.poll());
		}
		r.append(s);
		return r.toString();
	}

	public static boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}