package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] a = {3, 1, 1, 1};
		System.out.println(search2(a, 3));
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
    

    public static boolean search2(int[] nums, int target) {
        return (searchUtil(nums, target) >= 0);
    }
    private static int searchUtil(int[] nums, int target) {        
        return searchUtil(nums, 0, nums.length - 1, target);
	}
    private static int searchUtil(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        
        int m = (l + r) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[l] < nums[m]) {
            if (target >= nums[l] && target <= nums[m]) {
                return searchUtil(nums, l, m - 1, target);
            } else {
                return searchUtil(nums, m + 1, r, target);
            }
        } else if (nums[m] < nums[r]) {
            if (target >= nums[m] && target <= nums[r]) {
                return searchUtil(nums, m + 1, r, target);
            } else {
                return searchUtil(nums, l, m - 1, target);
            }
        } else if (nums[l] == nums[m] && nums[l] != nums[r]) {
            return searchUtil(nums, m + 1, r, target);
        } else if (nums[r] == nums[m] && nums[l] != nums[r]) {
            return searchUtil(nums, l, m-1, target);
        } else {
            int result = searchUtil(nums, l, m - 1, target);
            if (result == - 1) {
                result = searchUtil(nums, m + 1, r, target);
            }
            return result;
        }
    }
}

