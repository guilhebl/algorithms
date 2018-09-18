package com.guilhebl.algo.arrays;

public class TrappingWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[height.length-1] = height[height.length-1];
        for (int j = height.length-2; j >= 0; j--) {
            right[j] = Math.max(right[j+1], height[j]);
        }

        int total = 0;
        int[] water = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            water[i] = Math.min(left[i], right[i]) - height[i];
            total += water[i];
        }

        return total;
    }
}
