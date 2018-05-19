package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 *
 *
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] a = {1, 0, -1, -4, 2, 3};
        List<List<Integer>> r = new ThreeSum().threeSum(a);

        printResults(r);
    }

    public static void printResults(List<List<Integer>> r) {
        for (List<Integer> integers : r) {
            System.out.println();
            for (Integer i : integers) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length <= 2) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        Set<String> lists = new HashSet<>();

        while (i < n - 2) {
            int j = i + 1;
            int k = n-1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {

                    String key = "" + nums[i] + "-" + nums[j] + "-" + nums[k];
                    if (!lists.contains(key)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        lists.add(key);
                    }
                    j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }
            i++;
        }

        return result;
    }

}
