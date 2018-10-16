package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. get all subsets that sum up to a multiple of K
 * <p>
 * 2. print All Subsets Summing Up To N
 * <p>
 * 3. check if there is a subset in array that sums up to N -> isSubsetSum
 *
 * @author root
 */
public class SubsetSum {

    public static List<List<Integer>> getAllSubsetsSum(int a[], int i, int k,
                                                       List<Integer> list) {
        List<List<Integer>> result2 = null;
        if (i >= a.length) {
            return null;
        } else if (k != 0 && k % (a.length) == 0) {
            result2 = new ArrayList<>();
            result2.add(list);
            return result2;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int j = i; j < a.length; j++) {
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(a[j]);
            result2 = getAllSubsetsSum(a, j + 1, k + a[j], list2);
            if (result2 != null) {
                result.addAll(result2);
            }
        }

        return result;
    }

    public static void printListInt(List<Integer> intList) {

        for (Integer i : intList) {
            System.out.print(i + " ");
        }

    }

    public static void solveGetAllSubsetSum() {

        int a[] = {1, 2, 3, 4, 5};
        List<Integer> intList = new ArrayList<>();

        List<List<Integer>> listInts = getAllSubsetsSum(a, 0, 0, intList);
        if (!listInts.isEmpty()) {
            for (List<Integer> listI : listInts) {
                printListInt(listI);
                System.out.println();
            }
        }

    }

    public static void printAllSubsetsSummingUpToN(int sum, String s) {

        if (sum == 0) {
            System.out.println(s);
        } else if (sum > 0) {

            for (int i = 1; i <= sum; i++) {
                printAllSubsetsSummingUpToN(sum - i, s + " " + i);
            }
        }
    }

    public static boolean isSubsetSum(int set[], int n, int sum) {
        // The value of subset[i][j] will be true if there is a subset of
        // set[0..j-1]
        // with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }

        // to print table
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(subset[i][j] + " ");
            System.out.println();
        }

        return subset[sum][n];
    }

}
