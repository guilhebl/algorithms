package com.guilhebl.algo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13714
 *
 */
public class Similars {

	public static void main(String[] args) {
		System.out.println(maxsim(1,10));
		System.out.println(maxsim(1,99));
		System.out.println(maxsim(99, 100));
		System.out.println(maxsim(1000, 1010));
		System.out.println(maxsim(444, 454));
	}
	
	public static int maxsim(int l, int r) {
		int maxSim = 0;
		int[] a = new int[(r - l) + 1];
		int j = 0;
		
		for (int i = l; i <= r; i++) {
			a[j] = i;
			j++;
		}

		for (int i = 0; i < a.length; i++) {
			for (j = i+1; j < a.length; j++) {
				maxSim = Math.max(maxSim, getCountSimilarDigits(a[i],a[j]));
			}
		}
				
		return maxSim;
	}

	private static int getCountSimilarDigits(int i, int j) {
		int count = 0;
		int[] aI = getArrayDigits(i);				
		int[] aJ = getArrayDigits(j);

		for (int k = 0; k < 10; k++) {						
			if (aI[k] > 0 && aJ[k] > 0) {
				count ++;
			}
		}		
		
		return count;
	}

	private static int[] getArrayDigits(int i) {
		List<Integer> iList = new ArrayList<>();
		int iN;		
		while(i > 0) {
			iN = i % 10;
			iList.add(iN);
			i = i / 10;
		}
		int[] a = new int[10];
		for (Integer integer : iList) {
			a[integer]++;
		}		
		return a;
	}
	
}