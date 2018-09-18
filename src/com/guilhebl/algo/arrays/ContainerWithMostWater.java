package com.guilhebl.algo.arrays;

public class ContainerWithMostWater {

    //Driver program
    public static void main(String args[]) {
        ContainerWithMostWater m = new ContainerWithMostWater();
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(m.maxArea(a));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 3) return 0;

        int l = 0;
        int r = height.length-1;

        int max = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                int area = height[l] * (r - l);
                if (area > max) {
                    max = area;
                }
                l++;
            } else if (height[l] > height[r]) {
                int area = height[r] * (r - l);
                if (area > max) {
                    max = area;
                }
                r--;
            }
        }

        return max;
    }
}
