package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/find-peak-element/
 *
 */
public class FindPeakElement {

	public static void main(String[] args) {
		int[] a = {3,2,1};
		System.out.println(findPeakElement(a));		
		int[] a2 = {1, 2, 3, 4};
		System.out.println(findPeakElement2(a2));
		int[] a3 = {3, 4, 6, 8, 9, 1, 2};
		System.out.println(findPeakElement(a3));
	}
	
	public static int findPeakElement(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int l = 0, h = nums.length-1;
		int m = -1;
		while (l < h) {
			m = (l + h)/2;
			if (m + 1 < nums.length && nums[m] > nums[m + 1]) {
				if (m - 1 >= 0 && nums[m-1] > nums[m]) {
					h = m - 1;
				} else {
					return m;	
				}
				
			} else if (nums[m] > nums[l]) {
				l = m + 1;
			} else if (nums[m] < nums[h]) {
				if (m == 0) {
					l = m + 1;
				} else {
					h = m - 1;
				}
			}
		}
		return l;
	}
	
	public static int findPeakElement2(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		if (nums[0] > nums[1]) {
			return 0;
		}
		
		for (int i = 1; i < nums.length-1; i++) {
			if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
				return i;
			}
		}
		
		return nums.length-1;
	}

}
