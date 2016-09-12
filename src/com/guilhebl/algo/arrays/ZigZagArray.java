package com.guilhebl.algo.arrays;

/**
 * 
 * https://careercup.com/question?id=5681702473039872
 *
 */
public class ZigZagArray {
	public static void main(String[] args) {
		int[] a = {1,4,5,2,3};
		
		int[] r = getZigZag(a);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
		
		System.out.println();
		int[] a2 = {1,2,3};
		int[] r2 = getZigZag(a2);
		for (int i = 0; i < r2.length; i++) {
			System.out.print(r2[i] + " ");
		}

	}

	// 
	public static int[] getZigZag(int[] a) {
		if (a == null || a.length <= 1) return a;
		
		int temp;
		for (int i = 1; i < a.length; i+=2) {
			if (a[i] < a[i-1]) {
				temp = a[i];
				a[i] = a[i-1];
				a[i-1] = temp;
			}
			
			if (i < a.length-1 && a[i] < a[i + 1]) {
				temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}			
		}
		
		return a;
	}
}
