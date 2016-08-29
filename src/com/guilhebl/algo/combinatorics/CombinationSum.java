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
		int[] a = {4,2,1};
		System.out.println("\n - " + combinationSum4(a, 32));
	}
	
	 public static int combinationSum4(int[] nums, int target) {	        
	        if (nums == null || nums.length == 0)
	            return 0;
	        int[] dp = new int[target + 1];
	        dp[0] = 1;
	        for(int i = 1; i <= target; ++i) {
	            for (int num: nums) {
	                    dp[i] += i - num >= 0 ? dp[i - num]: 0;
	            }
	        }
	        return dp[target];
	    }
	public static void printLists(List<List<Integer>> list) {
		if (list == null) return;
		
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
    public static int combinationSum4b(int[] nums, int target) {
    	Arrays.sort(nums);
    	List<List<Integer>> r = new ArrayList<>();
    	combinationSum(r, new ArrayList<Integer>(), nums, target, 0);	
    	return r.size();
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
    		for (int i = 0; i < nums.length; i++) {
    			tempList.add(nums[i]);
    			combinationSum(list, tempList, nums, rem - nums[i], i);
    			tempList.remove(tempList.size()-1);
    		}
    	}
    }
}
