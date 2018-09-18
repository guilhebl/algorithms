package com.guilhebl.algo.arrays;

public class FindMedianTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {3, 4};

        System.out.println(new FindMedianTwoSortedArrays().findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0D;
        }
        int[] m = mergeArrays(nums1, nums2);
        int n = m.length;

        if (n % 2 == 0) {
            int idx = (n - 1)/2;
            int m1 = m[idx];
            int m2 = m[idx+1];

            return (double) (m1 + m2)/2;
        }

        int idx = (n - 1)/2;
        return (double) m[idx];
    }

    private int[] mergeArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int m[] = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                m[k] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                m[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            m[k++] = a[i++];
        }

        while (j < b.length) {
            m[k++] = b[j++];
        }

        return m;
    }

}



