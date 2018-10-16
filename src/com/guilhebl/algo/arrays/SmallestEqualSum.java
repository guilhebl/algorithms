package com.guilhebl.algo.arrays;

/**
 * https://careercup.com/question?id=5433766164561920
 */
public class SmallestEqualSum {

    //Driver program
    public static void main(String args[]) {
        SmallestEqualSum m = new SmallestEqualSum();

        int a[] = {1,3,2,2,1,3};

        System.out.println(m.smallestEqualSum(a));
    }

    public int smallestEqualSum(int[] a) {
        if (a == null) return 0;

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += a[j];
            }

            if (i == a.length - 1) return sum;

            int subSum = 0;
            int k = i + 1;
            while (k < a.length) {
                subSum += a[k];
                if (subSum == sum) {
                    subSum = 0;
                    if (k == a.length - 1) return sum;
                }
                k++;
            }

            if (k == a.length-1) return sum;
        }
        return 0;
    }
}
