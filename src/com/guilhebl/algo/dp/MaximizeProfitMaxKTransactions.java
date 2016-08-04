package com.guilhebl.algo.dp;

public class MaximizeProfitMaxKTransactions {

	public static void main(String[] args) {
		solveMaximizeProfitMaxKTransactions();
	}
	
	public static void solveMaximizeProfitMaxKTransactions() {	
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		System.out.println(maximizeProfit(price, 3));
	}
	
	private static int maximizeProfit(int[] v, int k1)
	{
		int k = k1*2; // buy and sell counted as unique transactions		
		int[] s0 = new int[k+1];
		int[] s1 = new int[k+1];
		
		s1[0] = Integer.MIN_VALUE;
		for (int j = 1; j <= k; j++) {
			s1[j] = -v[0];
		}

		for (int i = 1; i < v.length; i++) {
			for (int j = k; j>=1; j--) {
				s1[j] = Math.max(s1[j], s0[j-1]-v[i]);
				s0[j] = Math.max(s0[j], s1[j-1]+v[i]);
			}
		}
		return s0[k];
	}
}
