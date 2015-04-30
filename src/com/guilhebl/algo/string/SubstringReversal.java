package com.guilhebl.algo.string;

public class SubstringReversal {

	public static void main(String[] args) {
		solveSubstringReversal();
	}
	
	public static void solveSubstringReversal() {
		String s = "abdc";
		printArray(solve(s));
		String s1 = "aabbcc";
		printArray(solve(s1));
		String s2 = "misof";
		printArray(solve(s2));
		String s3 = "ivan";
		printArray(solve(s3));
		String s4 = "thisseemstobeaneasyproblem";
		printArray(solve(s4));
	}
	
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] solve(String s) {
		int[] range = null;
		char[] c = s.toCharArray();
		int i = 0, j = 0;
		int s1 = 0, s2 = -1, li = 0;
		boolean swapped = false;
		int minVal = -1;
		int val = 0;
		
		for (i = 0; i < c.length && !swapped; i++) {
			s1 = i;
			li = c[i] - 'a';			
			j = c.length - 1;
			minVal = Integer.MAX_VALUE;
			
			while (!swapped && (li > 0 && j > i)) {
				val = c[j] - 'a';
				if (minVal >= val) {
					s2 = j;
					minVal = val;
				}
				j--;			
			}
			if (minVal != Integer.MAX_VALUE && minVal < li) {
				swapped = true;
			}						
		}
		
		range = new int[2];
		range[0] = s1 == s2 ? 0 : s1;
		range[1] = s2 == s1 ? 0 : s2;
		return range;
	}
	
}
