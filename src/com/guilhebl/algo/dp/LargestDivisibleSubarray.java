package com.guilhebl.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/largest-divisible-subset/
 *
 */
public class LargestDivisibleSubarray {

	public static void main(String[] args) {
		int[] a = {1,2,4,8,16};
		
		printList(largestDivisibleSubset(a));
	}
	
    private static void printList(List<Integer> largestDivisibleSubset) {
		for (Integer integer : largestDivisibleSubset) {
			System.out.print(integer + " ");
		}
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
	        if (nums == null) {
	            return null;
	        }
	        List<Integer> r = new ArrayList<>();
	        if (nums.length == 0) {
	            return r;
	        }
	        if (nums.length == 1) {
	            r.add(nums[0]);
	            return r;
	        }	        	       
	        
	        int n = nums.length;
	        int[] dp = new int[n];
	        Arrays.sort(nums);
	        
	        dp[0] = 1;
	        boolean foundLocalMax = false;
	        
	        for(int i = 1; i < n; i++) {
	        	foundLocalMax = false;
	            for(int j = i-1; j >=0 && !foundLocalMax; j--) {
	                if (nums[i] % nums[j] == 0) {
	                    dp[i] = dp[j] + 1;
	                    foundLocalMax = true;
	                }
	            }
	        }
	        
	        int maxIndex = 0;
	        int max = dp[0];
	        for(int i = 1; i < n; i++) {
	            if (dp[i] > max) {
	                maxIndex = i;
	                max = dp[i];
	            }
	        }
	        	        
	        int temp = nums[maxIndex];
	        for(int i = maxIndex; i>=0; i--) {
	            if (temp % nums[i] == 0) {
	                r.add(nums[i]);
	                temp = nums[i];
	            }
	        }
	        
	        return r;
	    }
}
