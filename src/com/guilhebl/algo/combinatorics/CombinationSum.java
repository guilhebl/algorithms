package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/combination-sum/
 *
 */
public class CombinationSum {
	
	public static void main(String[] args) {
		int[] a = {1};
		printLists(combinationSum(a, 2));
	}
	
	public static void printLists(List<List<Integer>> list) {
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> r = new ArrayList<>();
    	combinationSum(r, new ArrayList<Integer>(), candidates, target, 0);	
    	return r;
    }
    
    public static void combinationSum(List<List<Integer>> list, List<Integer> tempList, int[] nums, int rem, int start) {
    	if (rem < 0) {
    		return;
    	} else if (rem == 0) {
    		list.add(new ArrayList<>(tempList));
    	} else {
    		for (int i = start; i < nums.length; i++) {
    			tempList.add(nums[i]);
    			combinationSum(list, tempList, nums, rem - nums[i], i);
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
}
