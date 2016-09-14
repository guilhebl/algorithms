package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/permutations-ii/
 *
 */
public class PermutationsII {
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		List<List<Integer>> list = permuteUnique(a);
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

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> r = new ArrayList<>();;
		backtrack(r, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return r;
	}

	private static void backtrack(List<List<Integer>> r, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			r.add(new ArrayList<>(tempList));
		} else {
			for(int j = 0; j < nums.length; j++) {
				if(used[j] || (j > 0 && !used[j] && nums[j] == nums[j - 1] && !used[j-1])) {
					continue;
				}
				used[j] = true;
				tempList.add(nums[j]);
				backtrack(r, tempList, nums, used);
				used[j] = false;
				tempList.remove(tempList.size()-1);
			}
		}
	}
		
}