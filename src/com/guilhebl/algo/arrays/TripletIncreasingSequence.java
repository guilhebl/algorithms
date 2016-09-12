package com.guilhebl.algo.arrays;

/**
 * 
 * https://careercup.com/question?id=14960662
 *
 */
public class TripletIncreasingSequence {
	
	public static void main(String[] args) {
		int[] a = {4,7,5,1,3,8,9,6,2};
		System.out.println(countTripletsIncreasingSeq(a));
	}

	public static int countTripletsIncreasingSeq(int[] a) {
		int count = 0;
		int[] lMin = new int[a.length];
		int[] rMax = new int[a.length];
		
		lMin[0] = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[lMin[i-1]]) {
				lMin[i] = i;				
			} else {
				lMin[i] = lMin[i-1];
			}
		}		

		rMax[a.length-1] = a.length-1;
		for (int i = a.length-2; i >= 0; i--) {
			if (a[i] > a[rMax[i+1]]) {
				rMax[i] = i;				
			} else {
				rMax[i] = rMax[i+1];
			}
		}		
		
		for (int i = 1; i < a.length-1; i++) {
			if (lMin[i] < i && i < rMax[i]) {
				count++;
				System.out.println(a[lMin[i]] + " " + a[i] + " " + a[rMax[i]]);
			}
		}

		return count;
	}	
	
}
