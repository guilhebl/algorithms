package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all permutations of string
 * 
 *
 */
public class PrintAllPerms {

	public static void main(String[] args) {		
		printAllStringCombinations("abc".toCharArray(), 3);
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

	public static void printAllPermutations(char[] s, int i) {
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

	public static void printAllSubsets(String s) {
		List<String> l = getAllSubsets(s.toCharArray());
		for (String string : l) {
			System.out.println(string + " ");
		}
		System.out.println();
	}

	public static List<String> getAllSubsets(char a[]) {
		List<String> result = new ArrayList<>();
		int n = a.length;
		int maxBin = new Double(Math.pow(2, n)).intValue();

		int i = 0;
		while (i < maxBin) {
			StringBuilder sb = new StringBuilder("");
			int j = 0;
			int x = i;
			while (x > 0) {
				if (((x & 1) > 0)) {
					sb.append(a[j]);
				}
				j++;
				x = x >> 1;
			}
			result.add(sb.toString());
			i++;
		}

		return result;
	}
	
	public static void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

	public static void printAllStringCombinations(char[] s, int size) {
		List<String> l = getCombinations(s, size);
		
		// filter out invalid strings
		List<String> invalidList = new ArrayList<>();
		for (String st : l) {						
			if (!isValid(st)) {
				invalidList.add(st);
			}
		}
		l.removeAll(invalidList);		
		
		for (String string : l) {
			System.out.println(string + " ");
		}
		System.out.println();
	}

    private static boolean isValid(String st) {
		char[] c = st.toCharArray();
		int countBs = 0;
		int countConsecutiveCs = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'b') {
				countBs++;
			} else if (c[i] == 'c' && i + 1 < c.length && c[i+1] == 'c') {
				countConsecutiveCs++;
			}
		}
		
		if (countBs > 1 || countConsecutiveCs > 1) {
			return false;
		}
    	
    	return true;
	}

	public static List<String> getCombinations(char[] c, int size) {
    	List<String> r = new ArrayList<>();
    	generateCombinations(r, new StringBuilder(), c, size);	
    	return r;
    }
    
    public static void generateCombinations(List<String> list, StringBuilder sb, char[] c, int size) {
    	if (sb.length() == size) {    		
    		list.add(sb.toString());
    	} else {
    		for (int i = 0; i < c.length; i++) {
    			sb.append(c[i]);
    			generateCombinations(list, new StringBuilder(sb.toString()), c, size);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    	}
    }

}