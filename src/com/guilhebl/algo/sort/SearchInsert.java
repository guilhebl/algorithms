package com.guilhebl.algo.sort;

/**
 * 
 * https://leetcode.com/problems/search-insert-position/
 *
 */
public class SearchInsert {

	public static void main(String[] args) {
		int[] a = {1, 2, 4, 6 , 7};
		
		System.out.println(searchInsert(a, 3));
	}
	
    public static int searchInsert(int[] nums, int target) {
    	if (target < nums[0]) {
    		return 0;
    	} 
    	if (target > nums[nums.length-1]) {
    		return nums.length;
    	}     	
    	
        return binSearch(nums, 0, nums.length - 1, target);
    }
    
    private static int binSearch(int[] nums, int l, int h, int t) {
        if (l > h) {
            return - 1;
        }
        int m = (l + h) / 2;
        
        if (t == nums[m]) {
            return m;
        } 
        if ((h-l) == 1 || (h-l) == 0) {
        	if (t > nums[h]) {
        		return h+1;
        	} else if (t > nums[m]) {
        		return h;
        	} else {
        		return m;
        	}
        }
        
        else if (nums[m] > t) {
            return binSearch(nums, l, m - 1, t);
        }
        return binSearch(nums, m + 1, h, t);
    }
}
