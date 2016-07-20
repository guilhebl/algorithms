package com.guilhebl.algo.arrays;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 */
public class FindMinSortedArray {

	public static void main(String[] args) {
		int[] a = {8,9,2,3,4,5,6};
		System.out.println(findMin(a));
	}
	
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        return findMin(nums, 0, nums.length - 1);
    }
    
    public static int findMin(int[] nums, int l, int r) {
        int m = -1;
        while(l < r) {
            m = (l + r) / 2;
            if (nums[l] > nums[m]) {
                if (l == m - 1) {
                    return nums[m];
                }
                r = r - 1;
            } else if (nums[r] < nums[m]) {
                if (r == m + 1) {
                    return nums[r];
                }
                l = m + 1;
            } else if (nums[m] <= nums[r]) {
                if (m == 0 || (m > 0 && nums[m-1] > nums[m])) {
                    return nums[m];
                }
                r = r - 1;
            }
        }
        return -1;
    }
}
