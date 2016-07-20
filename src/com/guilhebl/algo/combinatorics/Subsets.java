package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/subsets/
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int numSets = new Double(Math.pow(2, nums.length)).intValue();
        
        int i = 0;
        int j = 0;
        int num = 0;
        List<Integer> list = null;
        while (i < numSets) {
            num = i;
            j = 0;
            list = new ArrayList<>();
            while(num > 0) {
                if ((num & 1) > 0) {
                    list.add(nums[j]);
                }
                j++;
                num = num >> 1;
            }
            subsets.add(list);
            i++;
        }
        
        return subsets;
    }
}
