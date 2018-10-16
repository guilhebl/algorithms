package com.guilhebl.algo.arrays;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        if (m > n) {
            int[] temp = a;
            a = b;
            b = temp;
            m = a.length;
            n = b.length;
        }

        int iMin = 0;
        int iMax = m;
        int halfLen = (n + m + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && a[i] < b[j-1]) {
                iMin++;
            } else if (i > iMin && a[i-1] > b[j]) {
                iMax--;
            } else {
                int maxLeft = 0;
                if (i == 0) maxLeft = b[j-1];
                else if (j == 0) maxLeft = a[i-1];
                else maxLeft = Math.max(a[i-1], b[j-1]);
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = b[j];
                else if (j == n) minRight = a[i];
                else minRight = Math.min(b[j], a[i]);

                return (maxLeft + minRight) / 2.0D;
            }


        }
        return 0.0D;
    }
}