package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://careercup.com/question?id=5726391455711232
 *
 */
public class CombinationNumberKBits {	
	public static void main(String[] args) {
		printCombinationsKBits(3);
	}

	public static void printCombinationsKBits(int k) {
		if (k <= 0) return;
		
		int pow = new Double(Math.pow(2, k)).intValue();
		int i = 0, j = 0;
		int num = 0;
		List<int[]> r = new ArrayList<>();
		int[] arr = null;		
		
		while (i < pow) {
			num = i;
			j = k-1;
			arr = new int[k];
			while(num > 0 && j >= 0) {
				if ((num & 1) > 0) {
					arr[j] = 1;
				}
				j--;
				num = num >> 1;
			}
			i++;
			r.add(arr);
		}
		
		for (int l = 0; l <= k && !r.isEmpty(); l++) {
			List<int[]> subset = findArraysWithKBits(r, l);						
			printArrays(subset);
			r.removeAll(subset);
		}		
			
	}
	private static List<int[]> findArraysWithKBits(List<int[]> arr, int k) {			
		List<int[]> r = new ArrayList<>();
		for (int[] is : arr) {
			if (countBits(is) == k) {
				r.add(is);
			}
		}
		return r;
	}
	
	public static int countBits(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
			}
		}
		return count;
	}
	
	public static void printArrays(List<int[]> arr) {
		for (int[] is : arr) {
			System.out.println();
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i] + " ");	
			}
		}
	}		
}