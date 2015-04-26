package com.guilhebl.algo.dp;

/**
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 *
 */
public class FindMaxDonationsBadNeighbors {

		public static void main(String[] args) {
			solveMaxDonations();
		}
		
		public static void solveMaxDonations() {				    	
			int[] a = { 10, 3, 2, 5, 7, 8 };
			System.out.println(maxDonations(a));
	
			int[] a1 = { 11, 15 };
			System.out.println(maxDonations(a1));
			int[] a2 = { 7, 7, 7, 7, 7, 7, 7 };
			System.out.println(maxDonations(a2));
			int[] a3 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
			System.out.println(maxDonations(a3));
			int[] a4 = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
					  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
					  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
			System.out.println(maxDonations(a4));

		}
		
		public static int maxDonations(int[] a) {
			if (a == null || a.length == 0) {
				return 0;
			} else if (a.length == 1) {
				return a[0];
			} else if (a.length == 2) {
				return Math.max(a[0], a[1]);
			}
			int n = a.length;
			int dp[] = new int[n];
			dp[0] = a[0];			
										
			if (a[n-1] < a[0] || a[1] == a[0]) {
				dp[1] = a[0];
				dp[2] = a[0] + a[2];
			} else {
				dp[1] = a[1];
				dp[2] = Math.max(a[0] + a[2], a[1]);
			}
			
			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + a[i], dp[i-3] + a[i]));
			}
						
			return Math.max(dp[n-1] - a[0], dp[n-2]);
		}
		
		
}