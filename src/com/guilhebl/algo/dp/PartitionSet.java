package com.guilhebl.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://careercup.com/question?id=5665792839385088
 *
 */
public class PartitionSet {

	public static void main(String[] args) {
		int[] a = {1,1,1,1,1};
		isDivisible(a);

		int[] b = {1,2,2};
		isDivisible(b);
	}
	
	public static boolean isDivisible(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		boolean foundAny = false;
		Map<Integer, Boolean> removableElements = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!removableElements.containsKey(a[i])) {
				if ((sum - a[i]) % 2 == 0) {
					foundAny = isSubsetSum(removeElement(a,i), (sum - a[i])/2);
					removableElements.put(a[i], foundAny);
				} else {
					removableElements.put(a[i], Boolean.FALSE);
				}
			}
		}
		if (foundAny) {
			StringBuilder sb = new StringBuilder();
			for(Map.Entry<Integer, Boolean> e : removableElements.entrySet()) {
				if (e.getValue().equals(Boolean.TRUE)) {
					sb.append(e.getKey() + " ");
				}
			}
			System.out.println("Yes. removing elements: " + sb.toString());
		} else {
			System.out.println("No");
		}
		
		return foundAny;
	}
	
	// returns a new array without element at index i of a
	private static int[] removeElement(int[] a, int i) {
		int[] b = new int[a.length-1];
		int k = 0;
		for (int j = 0; j < a.length; j++) {
			if (j != i) {
				b[k++] = a[j];
			}
		}
		return b;
	}

	public static boolean isSubsetSum(int[] a, int sum) {
		boolean dp[][] = new boolean[sum+1][a.length+1];

		// array with sum 0 and any element true
		for (int i = 0; i < dp.length; i++) {
			dp[0][i] = true;
		}

		// array with sum non-zero and no element is false
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= a.length; j++) {
				dp[i][j] = dp[i-1][j-1];	
				if (i >= a[j-1]) {
					dp[i][j] = dp[i][j] || dp[i-a[j-1]][j-1];
				}
			}
		}

		return dp[sum][a.length];
	}
}
