package com.guilhebl.algo.sort;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/3sum-closest/
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		ThreeSumClosest t = new ThreeSumClosest();
		int[] a = {1,2,4,8,16,32,64,128};
		System.out.println(t.threeSumClosest(a, 82));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int l = 0;
		int h = nums.length - 1;
		int j = 0, k = 0;
		int minDiff = Integer.MAX_VALUE;
		int minSum = 0;

		while (l < h - 1) {
			j = l + 1;
			k = h;
			while (j < k) {
				int sum = nums[l] + nums[j] + nums[k];
				int diff = Math.abs(sum - target);
				if (diff < minDiff) {
					minDiff = diff;
					minSum = sum;
					if (minDiff == 0) {
						return minSum;
					}
				}
				if (sum > target) {
					k--;
				} else {
					j++;
				}
			}
			l++;
		}
		return minSum;
	}
}
