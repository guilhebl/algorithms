package com.guilhebl.algo.dp;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/coin-change/
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		int[] a = {1,2,5};
		System.out.println(coinChange(a, 11));
		
		int[] a2 = {2};
		System.out.println(coinChange(a2, 3));

		int[] c = {186,419,83,408};		
		System.out.println(coinChange(c, 6249));
	}
	
    public static int coinChange(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j] && (((long) dp[i - coins[j]] + 1) < dp[i])) {
					dp[i] = dp[i - coins[j]] + 1;
				}
			}
		}
		return (dp[amount] <= 0 || dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
	}
}
