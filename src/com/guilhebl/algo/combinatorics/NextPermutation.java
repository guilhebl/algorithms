package com.guilhebl.algo.combinatorics;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/articles/next-permutation/
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		//int[] a = {1,5,8,4,7,6,5,3,1};
		int[] a = {1,5,1};
		nextPermutation(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        
        int j = i + 1;
        while(j < nums.length && nums[j] > nums[i]) {
            j++;
        }
        swap(nums, i, j-1);
        
        j = i + 1;
        int k = nums.length - 1;
        while(j < k) {
            swap(nums,j,k);
            j++;
            k--;
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
