package com.guilhebl.algo.arrays;

/**
 * 
 * https://careercup.com/question?id=5156071640399872
 *
 */
public class RepeatingNumber {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,16};
				
		System.out.println(repeatingNumber(a));				
	}
	
	public static int repeatingNumber(int[] array) {
		int n = array.length - 1;
		
		int sumOfSequence = (n*(n+1))/2;

		for (int element : array) {
			sumOfSequence -= element;
		}

		return Math.abs(sumOfSequence);
	}
	
}
