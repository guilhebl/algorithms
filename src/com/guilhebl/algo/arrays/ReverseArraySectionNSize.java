package com.guilhebl.algo.arrays;

import java.util.Arrays;

/**
 * 
 * https://careercup.com/question?id=5181130190880768
 *
 */
public class ReverseArraySectionNSize {

	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5,6,7,8,9};		
		printArray(getReversedNSectionArray(a, 3));
	}
	
	private static void printArray(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}		
	}

	public static Integer[] getReversedNSectionArray(Integer[] a, int n) {
		if (a == null || n > a.length || n < 1) {
			return null;
		}		
		if (n == 1) {
			return a;
		}
		int len = a.length;
		
		// if n = len just return reversed array
		if (n == len) {			
			return (Integer[]) Arrays.asList(a).stream().sorted((f1, f2) -> Integer.compare(f2, f1) * -1).toArray();
		}
		
		int s = -1; // sector size
		int rem = len; // remaining elements
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < len) {
			s = (n > rem) ? rem : n; // possible sector size
			j = i;
			k = i + s - 1;
			
			while (j < k) {
				swap(a, j, k);
				j++;
				k--;
			}
			i += s;
			rem -= s;
			
		}
		return a;
	}
	
	private static void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	
}
