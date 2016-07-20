package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 */
public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] a = {3, 1};
		System.out.println(search(a, 1));
	}
	
	public static int search(int[] nums, int target) {        
        return search(nums, 0, nums.length - 1, target);
	}

	// 1, 2, 3, 4
    public  static int search(int[] nums, int l, int r, int target) {
        int m = -1;
        while(l <= r) {
            m = (l + r) / 2;
        	if (target == nums[m]) {
        		return m;
        	}
        	else if (nums[l] <= nums[m]) {            	
            	if (target >= nums[l] && target < nums[m]) {
            		r = m -1; 
            	} else {
            		l = m + 1;
            	}
            } else if (nums[m] < nums[r]) {            	
            	if (target > nums[m] && target <= nums[r]) {
            		l = m + 1; 
            	} else {
            		r = r - 1;
            	}
            }
        }
        return -1;
    }
}

