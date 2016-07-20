package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Backtracking approach
 *
 */
public class SubsetsII {

	public static void main(String[] args) {
		int[] a = {4,4,4,1,4};
		printLists(subsetsWithDup(a));
	}
	
	private static void printLists(List<List<Integer>> subsetsWithDup) {
		for (List<Integer> list : subsetsWithDup) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null) {
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();
		generateSubsets(list, intList, nums, 0);
		return list;
	}
	
	private static void generateSubsets(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i-1]) {
				continue;
			}
			tempList.add(nums[i]);
			generateSubsets(list, tempList, nums, i + 1);
			tempList.remove(tempList.size()-1);
		}
	}
}
