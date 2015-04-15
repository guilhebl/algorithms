package com.guilhebl.algo.arrays;
import java.util.Arrays;

/**
 *
 * Given an array Of integers build a new array of integers such that every 2nd element of the array
is greater than its left and right element. 

eg: 
[1,4,5,2,3]

o/p:
[1,4,2,5,3]

 * @author root
 *
 */
public class GetOrderedArrayDecIncSequenceSwapping {

	public static void main(String[] args) {		
		int a[] = {4, 2, 7, 9, 8, 6};
		int b[] = getOrderedArrayDecIncSequenceSwapping(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

	/**
	 * based on sorting and iterative approach using aux. array: 
	 * 
	 * O(n*log(n)) time, O(n) space
	 * 
	 * @param a
	 * @return
	 */
	public static int[] getOrderedArrayDecIncSequence(int[] a) {
		if (a == null || a.length == 1) {
			return a;
		}
		Arrays.sort(a);		
		int[] b = new int[a.length];
		int k = 0;
		for (int i = 0, j = a.length-1; i < a.length && j >= i; i++, j--) {						
			b[k] = a[i];
			if (j > i) {
				b[k + 1] = a[j];	
			}						
			k+=2;			
		}
		
		return b;
	}

	/**
	 * Based on swapping adjacent positions: O(n) time, O(1) space
	 * @param a
	 * @return
	 */
	public static int[] getOrderedArrayDecIncSequenceSwapping(int[] a) {
		if (a == null || a.length == 1) {
			return a;
		}
		boolean odd = true;
		int temp;
		for (int i = 1; i < a.length; i++) {						
			if (odd) {
				if (a[i - 1] > a[i]) {
					temp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = temp;
				}
			} else {
				if (a[i - 1] < a[i]) {
					temp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = temp;
				}				
			}
			odd = !odd;
		}
		
		return a;
	}
	
}