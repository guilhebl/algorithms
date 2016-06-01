package com.guilhebl.algo.combinatorics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * https://careercup.com/question?id=5663263489523712
 *
 */
public class MergeStringsPreserveOrderCombination {

	public static void main(String[] args) {
		  Set<String> stringSet = new HashSet<String>();
		  getPermutationOfStringFiltered("heysam".toCharArray(), 0, "hey", "sam", stringSet);
		  List<String> strs = stringSet.stream().sorted().collect(Collectors.toList());
		  
		  for (String string : strs) {
			System.out.println(string);
		}
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

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}



}