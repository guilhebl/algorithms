package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class NumberGeneration {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		List<List<Integer>> listInts = getAllSubsets(a);
		if (!listInts.isEmpty()) {
			for (List<Integer> listI : listInts) {
				printListInt(listI);
				System.out.println();
			}
		}
	}
	
	public static void printListInt(List<Integer> intList) {
		for (Integer i : intList) {
			System.out.print(i + ",");
		}
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
