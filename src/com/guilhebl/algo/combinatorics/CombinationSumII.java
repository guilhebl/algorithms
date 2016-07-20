package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/combination-sum-ii/
 *
 */
public class CombinationSumII {
	
	public static void main(String[] args) {
		int[] a = {10, 1, 2, 7, 6, 1, 5};
		printLists(combinationSum2(a, 8));
	}
	
	public static void printLists(List<List<Integer>> list) {
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	int total = 0;
    	for (int i = 0; i < candidates.length; i++) {
			total += candidates[i];
		}
    	List<List<Integer>> r = new ArrayList<>();
    	
    	if (candidates[0] <= target && total >= target) {
    		combinationSum(r, new ArrayList<Integer>(), candidates, target, 0);	
    	}
    	
    	return r;
    }
    
    public static void combinationSum(List<List<Integer>> list, List<Integer> tempList, int[] nums, int rem, int start) {
    	if (rem < 0) {
    		return;
    	} else if (rem == 0) {
    		list.add(new ArrayList<>(tempList));
    	} else {
    		for (int i = start; i < nums.length; i++) {
    			if (i > start && nums[i] == nums[i-1]) {
    				continue;
    			}
    			tempList.add(nums[i]);
    			combinationSum(list, tempList, nums, rem - nums[i], i + 1);
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
}
