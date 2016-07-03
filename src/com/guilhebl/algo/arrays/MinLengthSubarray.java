package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 */
public class MinLengthSubarray {
 
	public int minSubArrayLen(int s, int[] nums) {     
		if(nums == null || nums.length == 0) {
            return 0;
        }
	        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        int l = 0;
        int r = -1;               
        
        while(r < nums.length) {
        	if (sum >= s) {
        		min = Math.min(min, r - l + 1);
        		sum -= nums[l];
        		l++;
        	} else {        		
        		r++;
        		if (r < nums.length) {
        			sum += nums[r];	
        		}        		
        	}
        	
		}
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}