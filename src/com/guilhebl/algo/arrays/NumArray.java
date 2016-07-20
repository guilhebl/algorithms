package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 */
public class NumArray {

	private int[] nums;
	
	public static void main(String[] args) {
		int[] a = {-2, 0, 3, -5, 2, -1};
		
		NumArray n = new NumArray(a);
		System.out.println(n.sumRange(0, 2));
		System.out.println(n.sumRange(2, 5));
		System.out.println(n.sumRange(0, 5));
	}
	
	public NumArray(int[] nums2) {
        this.nums = nums2;
        
        for (int i = 0; i < nums.length; i++) {
			nums[i] += nums[i-1];
		}
    }

    public int sumRange(int i, int j) {
    	if (i == 0) {
    		return nums[j];
    	}
    	return nums[j] - nums[i - 1];
    }
}
