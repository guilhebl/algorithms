package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class MergeStringsPreserveOrderCombination {

	public static void mergeStrings(String a, String b, int start, String str, List<String> result) {
		int len = a.length() - start;
		if (len == 0) {
			result.add(str);
			return;
		}
		for (int i = 0; i < len; i++) {
			String subA = a.substring(start, start+i+1);
			String subB = b.substring(start, start+i+1);
			mergeStrings(a, b, start+i+1, (str + subA + subB), result);
		}
	}
	
	private static List<String> mergeStrings(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) {
				return null;
		}
		List<String> result = new ArrayList<String>();
		mergeStrings(a, b, 0, "", result);
		mergeStrings(b, a, 0, "", result);
		return result;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String a = "hey";
		String b = "sam";
		
		List<String> merged = mergeStrings(a, b);
		System.out.println(merged);
	}
}