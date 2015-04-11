package com.guilhebl.algo;

/**
 * Find sum of first N EVEN fibonacci numbers until Limit
 * @author root
 *
 */
public class FindFibonacciSumEvensOfN {

	public static void main(String[] args) {
		System.out.println(findFibonacciSumEvensOfN(200, 4000000));
	}
	
	public static int findFibonacciOfN(int n) {
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
	}
	
	public static long findFibonacciSumEvensOfN(int n, long limit) {
		long f[] = new long[n + 1];
		long sumEvens = 0;
		f[0] = 0;
		f[1] = 1;
		
		int countMiss = 0;
		
		for(int i = 2; i <= n && countMiss < 3; i++) {					
			f[i] = f[i - 1] + f[i - 2];
			
			if (f[i] <= limit && f[i] % 2 == 0) {
				sumEvens += f[i]; 
			} else if (f[i] >= limit){
				countMiss++;
			}

		}
		
		return sumEvens;
	}
	
}