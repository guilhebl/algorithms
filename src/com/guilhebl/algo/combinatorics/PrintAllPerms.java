package com.guilhebl.algo.combinatorics;

/**
 * Print all permutations of string
 * 
 *
 */
public class PrintAllPerms {

	public static void main(String[] args) {
		printAllPermsGroups("wxyz");
	}
	
	public static void printAllPermsGroups(String s) {
		if (s == null || s.length() == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		recur(s.toCharArray(), sb, 0);
	}
	
	public static void recur(char[] c, StringBuilder s, int i) {		
		for(int j = i; j < c.length; j ++) {
			s.append(c[j]);
			System.out.println(s.toString());
			recur(c, s, j + 1);
			s.deleteCharAt(s.length()-1);			
		}		
	}

	private static void swapElements(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printAllListStringsPermutations(char[] s, int i) {
		if (i == s.length) {
			System.out.println(s);
		} else if (i < s.length) {
			for (int j = i; j < s.length; j++) {
				swapElements(s, i, j);
				printAllListStringsPermutations(s, i + 1);
				swapElements(s, i, j);
			}
		}
	}

	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}