package com.guilhebl.algo.dp;

/**
 * find max length of positive sequences in array
 * 
 * 
 * int[] a = {1,2,-3,2,3,4,-6,1,2,3,4,5,-8,5,6};
 * 
 * max= 5 -> 1,2,3,4,5
 * 
 * @author root
 *
 */
public class LargestPositiveSeqKadane {

	public static void main(String[] args) {
		 int[] a = {1,2,-3,2,3,4,-6,1,2,3,4,5,-8,5,6};
		 findLongestPositiveSeq(a);
	}

	public static void findLongestPositiveSeq(int a[]) {

		int currMax = 0, maxLongest = 0;
		int maxStartIndex = 0, currStartIndex = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				currMax++;
			} else {
				maxStartIndex = i + 1;
				if (currMax > maxLongest) {
					maxLongest = currMax;
					maxStartIndex = currStartIndex;
				}
				currMax = 0;
				currStartIndex = i + 1;
			}
		}

		System.out.println("max = " + maxLongest + " starting at: "
				+ maxStartIndex);
	}

}