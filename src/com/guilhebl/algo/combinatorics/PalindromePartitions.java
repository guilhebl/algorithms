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
		printList(partition("aab"));
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
}
