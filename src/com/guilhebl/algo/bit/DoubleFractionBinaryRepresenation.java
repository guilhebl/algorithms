package com.guilhebl.algo.bit;

/**
 * 
 * Given a real number between 0 and 7 (e.g., 0.72) that is passed in as a double, print
the binary representation. If the number cannot be represented accurately in binary
with at most 32 characters, print "ERROR."
 *
 */
public class DoubleFractionBinaryRepresenation {

	public static void main(String[] args) {
		System.out.println(getBinaryFractionAlternative(0.75));
	}

	public static String getBinaryFraction(double n) {
		if (n >= 1 || n <= 0) {
			return "ERROR";
		}
		
		StringBuilder sb = new StringBuilder(".");
		double x = 0.0D;
		
		while (n > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}
			
			x = 2 * n;
			if (x >= 1) {
				sb.append('1');
				n = x - 1;
			} else {
				sb.append('0');
				n = x;
			}
		}
		return sb.toString();
	}
	
	public static String getBinaryFractionAlternative(double n) {
		if (n >= 1 || n <= 0) {
			return "ERROR";
		}
		
		StringBuilder sb = new StringBuilder(".");
		double f = 0.5D;
		
		while (n > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}
			
			if (n >= f) {
				sb.append('1');
				n = n - f;
			} else {
				sb.append('0');
			}
			f = f / 2;
		}
		return sb.toString();
	}

}
