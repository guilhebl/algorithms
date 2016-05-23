package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



/**
 * Print all permutations of string
 * 
 * Example:
 * 
 * input: "abc"
 * 
 * output:
 * 
abc
acb
bac
bca
cba
cab

 * @author root
 *
 */
public class PrintAllPerms {

	public static void main(String[] args) {
		  Set<String> stringSet = new HashSet<String>();
		  getPermutationOfStringFiltered("heysam".toCharArray(), 0, "hey", "sam", stringSet);
		  List<String> strs = stringSet.stream().sorted().collect(Collectors.toList());
		  printSets(strs);
	}

	public static void getPermutationOfStringFiltered(char[] a, int i, String s1, String s2, Set<String> stringSet) {
		if (i == a.length) {
			String s = new String(a);
			if (isValidString(s, s1.toCharArray()) && isValidString(s, s2.toCharArray())) {
				stringSet.add(s);
			}				
		} else if (i < a.length) {
			for (int j = i; j < a.length; j++) {
				swap(a, i, j);
				getPermutationOfStringFiltered(a, i + 1, s1, s2, stringSet);
				swap(a, i, j);
			}
		}
	}

	private static boolean isValidString(String string, char[] c) {		
		int index = -1;
		int indexNext = -1;		
		for (int i = 0; i + 1 < c.length; i++) {
			index = string.indexOf(c[i]);
			indexNext = string.lastIndexOf(c[i + 1]);
			
			if (index >= indexNext) {
				return false;
			}
		}
		return true;
	}

	private static void swapElements(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

	
	private static List<String> filterOut(List<String> strs, String a, String b) {		
		List<String> strs2 = new ArrayList<>();
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		for (String string : strs) {
			if (isValidString(string, ac) && isValidString(string, bc)) {
				strs2.add(string);
			}
		}
				
		return null;
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
	
	public static void getPermutationOfString(char[] a, int i, Set<String> stringSet) {
		if (i == a.length) {
			stringSet.add(new String(a));
		} else if (i < a.length) {
			for (int j = i; j < a.length; j++) {
				swap(a, i, j);
				getPermutationOfString(a, i + 1, stringSet);
				swap(a, i, j);
			}
		}
	}

	public static void getPermutationOfString(char[] a, int i, Set<String> stringSet, int setSize) {
		if (i == a.length && a.length == setSize) {
			stringSet.add(new String(a));
		} else if (i < a.length) {
			for (int j = i; j < a.length; j++) {
				swap(a, i, j);
				getPermutationOfString(a, i + 1, stringSet, setSize);
				swap(a, i, j);
			}
		}
	}

	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void printSets(List<String> strs) {
		for (String string : strs) {
			System.out.println(string);
		}
	}
		
	
	public static void solvePrintAllPerms() {
		String s = "abc";
		printAllPerms(s.toCharArray(), 0);
	}

	public static void printAllPerms(char[] a, int i) {
		if (i > a.length) {
			return;
		} else if (i == a.length) {
			System.out.println(a);
		}
		for (int j = i; j < a.length; j++) {
			swap(a, i, j);
			printAllPerms(a, i + 1);
			swap(a, i, j);
		}
	}

}