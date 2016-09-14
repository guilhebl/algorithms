package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/permutations/
 *
 */
public class Permutations {
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		List<List<Integer>> list = permute(a);
		printList(list);
	}
	public static void printList(List<List<Integer>> list) {
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> r = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		permute(r, list, 0);
		return r;
	}

	private static void permute(List<List<Integer>> r, List<Integer> tempList, int i) {
		if (i == tempList.size()) {
			r.add(new ArrayList<>(tempList));
		} else if (i < tempList.size()) {
			for(int j = i; j < tempList.size(); j++) {
				swap(tempList, i, j);
				permute(r, tempList, i + 1);
				swap(tempList, i, j);
			}
		}
	}

	private static void swap(List<Integer> tempList, int i, int j) {
		int temp = tempList.get(j);
		tempList.set(j, tempList.get(i));
		tempList.set(i, temp);
	}		
}