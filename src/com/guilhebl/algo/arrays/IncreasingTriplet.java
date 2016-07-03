package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
	    if (nums == null || nums.length < 3) {
	    	return false;
	    }
	    
	    int s[] = new int[nums.length];
	    int g[] = new int[nums.length];

	    s[0] = -1;
	    int min = 0;
	    for (int i = 1; i < nums.length; i++) {
		    if (nums[i] <= nums[min]) {		    	
		    	min = i;
		    	s[min] = -1;
		    } else {
		    	s[i] = min;		    	
		    }
		}
	    
	    g[nums.length-1] = -1;
	    int max = nums.length - 1;	    	    
	    for (int i = nums.length - 2; i >=0; i--) {
		    if (nums[i] >= nums[max]) {		    	
		    	max = i;
		    	g[max] = -1;
		    } else {
		    	g[i] = max;		    	
		    }
		}
	    	    
	    for (int i = 0; i < nums.length; i++) {
		    if (s[i] != -1 && g[i] != -1) {		    	
		    	return true;
		    }
		}
	    
    	return false;
    }
}
