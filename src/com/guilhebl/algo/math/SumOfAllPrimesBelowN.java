package com.guilhebl.algo.math;

/**
 * Find sum of all prime numbers below N
 */
public class SumOfAllPrimesBelowN {

	public static void main(String[] args) {
		System.out.println(getSumOfAllPrimesBelowN(2000000));
	}

	public static long getSumOfAllPrimesBelowN(long n) {

		long sum = 1;
		int i = 0;
		while (i <= n) {
			if (isPrime(i)) {
				sum += i;

				if (sum > Long.MAX_VALUE) {
					System.out.println(sum);
				}
			}
			i++;
		}

		return sum;
	}

	public static boolean isPrime(long n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (long i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}