package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 */
public class PalindromePartitions {

	public static void main(String[] args) {
		System.out.println(isPalindrome("aA"));
	}
	
	public static void printList(List<List<String>> strs) {
		for (List<String> string : strs) {
			for (String string2 : string) {
				System.out.print(string2 + " ");
			}
			System.out.println();
		}
	}

    public static List<List<String>> partition(String s) {
    	List<List<String>> r = new ArrayList<>();
    	List<String> tempList = new ArrayList<>();
    	partition(r, tempList, s, 0);
    	return r;
    }

	private static void partition(List<List<String>> r, List<String> tempList, String s, int start) {
		if (start == s.length()) {
			r.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindromeSegment(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					partition(r, tempList, s, i + 1);
					tempList.remove(tempList.size()-1);
				}
			}
		}
	}
	
	private static boolean isPalindromeSegment(String s, int l, int h) {
		while(l < h) {
			if (s.charAt(l) != s.charAt(h)) {
				return false;
			}
			l++;
			h--;
		}
		return true;
	}
	
	public static boolean isPalindrome(String s) {
		if (s == null) return false;
		String[] words = s.split("\\W");
		if (words == null || words.length == 0) return true;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < words.length; i++) {
			String st = words[i].trim().toLowerCase();
			
			if (!st.equals("")) {
				sb.append(st);
			}
		}
		
		s = sb.toString();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}
