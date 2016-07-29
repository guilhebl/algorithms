package com.guilhebl.algo.math;

/**
 * 
 * Write a method to count the number of 2s between 0 and n
 *
 */
public class CountDigits {
	
	public static void main(String[] args) {
		System.out.println(count2sInRange(981));
	}
	
	public static int count2sInRangeAtDigit(int number, int d) {
		int powerOf10 = (int) Math.pow(10, d);
		int nextPowerOf10 = powerOf10 * 10;
		int right = number % powerOf10;
		int roundDown = number - number % nextPowerOf10;
		int roundUp = roundDown + nextPowerOf10;
		int digit = (number / powerOf10) % 10;

		if (digit < 2) { // if the digit in spot digit is
			return roundDown / 10;
		} else if (digit == 2) {
			return roundDown / 10 + right + 1;
		} else {
			return roundUp / 10;
		}
	}

	public static int count2sInRange(int number) {
		int count = 0;
		int len = String.valueOf(number).length();
		for (int digit = 0; digit < len; digit++) {
			count += count2sInRangeAtDigit(number, digit);
		}
		return count;
	}
}