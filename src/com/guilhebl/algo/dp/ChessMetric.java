package com.guilhebl.algo.dp;

/**
 * ChessMetric
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482
 * 
 * @author root
 *
 */
public class ChessMetric {

	public static void main(String[] args) {
		testChessMetric();
	}
	
	public static void testChessMetric() {
		int size = 3;
		int s[] = {0,0};
		int e[] = {1,0};
		int numMoves = 1;
		System.out.println(howMany(size, s, e, numMoves));

		int size1 = 3;
		int s1[] = {0,0};
		int e1[] = {1,2};
		int numMoves1 = 1;
		System.out.println(howMany(size1, s1, e1, numMoves1));
		
		int size2 = 3;
		int s2[] = {0,0};
		int e2[] = {2, 2};
		int numMoves2 = 1;
		System.out.println(howMany(size2, s2, e2, numMoves2));

		int size3 = 3;
		int s3[] = {0,0};
		int e3[] = {0, 0};
		int numMoves3 = 2;
		System.out.println(howMany(size3, s3, e3, numMoves3));

		int size4 = 100;
		int s4[] = {0,0};
		int e4[] = {0, 99};
		int numMoves4 = 50;
		System.out.println(howMany(size4, s4, e4, numMoves4));
	}
	
	public static long howMany(int size, int[] start, int[] end, int numMoves) {	
		int n = size;
		int m = numMoves;
		long dp[][][] = new long [n][n][m + 1];
		dp[start[0]][start[1]][0] = 1;
		long max;
		
		for (m = 1; m <= numMoves; m++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
				
					max = 0;
					// clockwise rotation starting from UP
					if (i > 0) {
						max += dp[i-1][j][m-1];
					}
					if (i > 0 && j < dp[i].length-1) {
						max += dp[i-1][j+1][m-1];	
					}						
					if (j < dp[i].length-1) {
						max += dp[i][j+1][m-1];	
					}						
					if (i < dp.length-1 && j < dp[i].length-1) {
						max += dp[i + 1][j+1][m-1];	
					}						
					if (i < dp.length-1) {
						max += dp[i + 1][j][m-1];	
					}						
					if (i < dp.length-1 && j > 0) {
						max += dp[i + 1][j-1][m-1];	
					}						
					if (j > 0) {
						max += dp[i][j-1][m-1];	
					}						
					if (i > 0 && j > 0) {
						max += dp[i-1][j-1][m-1];	
					}						

					// L positions
					if (i > 1 && j > 0) {
						max += dp[i-2][j-1][m-1];	
					}						
					if (i > 0 && j > 1) {
						max += dp[i-1][j-2][m-1];	
					}						
					if (i > 1 && j < dp[i].length-1) {
						max += dp[i-2][j+1][m-1];	
					}						
					if (i > 0 && j < dp[i].length-2) {
						max += dp[i-1][j+2][m-1];	
					}						
					if (i < dp.length-1 && j < dp[i].length-2) {
						max += dp[i+1][j+2][m-1];	
					}						
					if (i < dp.length-2 && j < dp[i].length-1) {
						max += dp[i+2][j+1][m-1];	
					}						
					if (i < dp.length-2 && j > 0) {
						max += dp[i+2][j-1][m-1];	
					}						
					if (i < dp.length-1 && j > 1) {
						max += dp[i+1][j-2][m-1];	
					}						
					
					dp[i][j][m] = max;			
				}
			}
		}		

		int x = end[0];
		int y = end[1];
		return dp[x][y][numMoves];
	}
	
}