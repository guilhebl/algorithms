package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combi-
nations ofn-pairs of parentheses.
 *
 *https://leetcode.com/problems/generate-parentheses/
 */
public class ParenCombinationGenerator {

	public static void main(String[] args) {
		printList(generateParens(3));
	}
	
	public static void printList(List<String> strs) {
		for (String string : strs) {
			System.out.println(string);
		}
	}
	
	public static List<String> generateParens(int count) {
		char[] c = new char[count * 2];
		ArrayList<String> strs = new ArrayList<>();
		addParens(strs, count, count, c, 0);
		return strs;
	}

	private static void addParens(ArrayList<String> strs, int leftParens, int rightParens, char[] c, int i) {
		if (leftParens < 0 || rightParens < 0 || rightParens < leftParens) {
			return;
		}
		
		if (leftParens == 0 && rightParens == 0) {
			strs.add(new String(c));
		} else {
			if (leftParens > 0) {
				c[i] = '(';
				addParens(strs, leftParens - 1, rightParens, c, i + 1);
			}
			
			if (rightParens > leftParens) {
				c[i] = ')';
				addParens(strs, leftParens, rightParens - 1, c, i + 1);
			}
		}
	}
}
