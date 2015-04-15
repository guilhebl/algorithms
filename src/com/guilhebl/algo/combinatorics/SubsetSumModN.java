package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * get sum of value of all subsets of int array a[] and return sum % mod
 * 
 *  Example: "123" = [1, 2, 3] --> 123 + 12 + 13 + 23 + 1 + 2 + 3 = 177.
 *  output: 123 % mod = X
 *
 *  using mod = 7 -> output = 123 % 7 = 3 
 *  
 * @author root
 *
 */
public class SubsetSumModN {

	public static void main(String[] args) {
		solveLuckyRemSubsetSum();
	}

	public static void solveLuckyRemSubsetSum() {
		System.out.println(getLuckyRemainder("123", 7));
	}

	public static int getLuckyRemainder(String x, int mod) {

		if (x == null || x.equals("")) {
			return -1;
		}

		char[] ca = x.toCharArray();
		int a[] = new int[x.length()];
		String s = null;

		for (int i = 0; i < ca.length; i++) {
			s = new Character(ca[i]).toString();
			a[i] = Integer.parseInt(s);
		}
		List<List<Integer>> listOfSets = getAllSubsets(a);

		int sum = 0;
		for (List<Integer> listInt : listOfSets) {
			for (Integer i : listInt) {
				sum += i;
			}
		}

		return sum % mod;
	}

	public static List<List<Integer>> getAllSubsets(int a[]) {
		List<List<Integer>> result = new ArrayList<>();
		int n = a.length;
		int maxBin = new Double(Math.pow(2, n)).intValue();

		int i = 0;
		while (i < maxBin) {
			List<Integer> list = new ArrayList<>();

			int j = 0;
			int x = i;
			while (x > 0) {
				if (((x & 1) > 0)) {
					list.add(a[j]);
				}
				j++;
				x = x >> 1;
			}
			result.add(list);
			i++;
		}

		return result;
	}

}
