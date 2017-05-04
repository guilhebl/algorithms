package com.guilhebl.algo.bit;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
	method to set all bits between i and j in N equal to M (e.g., M becomes a substring of
	N located at i and starting at j).
	EXAMPLE:
	Input: N = 10000000000, M = 10101, i = 2, j = 6
	Output: N = 10001010100

 * @author root
 *
 */
public class FitBinaryIntIntoAnotherBinaryInt {

	public static void main(String[] args) {
	
		int n = 1024;
		int m = 23;
		
		System.out.println(convertToBinaryString(n));
		System.out.println(convertToBinaryString(m));
		
		int z = fitNumInNum(n, m, 3, 7);
		System.out.println(convertToBinaryString(z));
		
	}
	
	public static int fitNumInNum(int n, int m, int i, int j) {
		 if (n <= 0 || m <= 0 || m > n || i < 0 || j < 0 || j < i) {
		  return -1;
		 }

		 if (m == n) {
		   return n;
		 }

		int lenM = getBinarySize(m);

		 if ((j - (i - 1)) != lenM) {
		   return -1;
		 }

		 int i0 = 0;

		// n = setRangeBits(n, i, j, false);  
		 while (i <= j && i0 < lenM) {
		   n = setBit(n, i, getBit(m, i0));
		   i++;
		   i0++;
		 }
		 
		 return n;
		}

		public static int setRangeBits(int n, int i, int j, boolean isSet) {
		 while (i <= j) {
		   n = setBit(n, i, isSet);
		   i++;
		 }
		 return n;
		}

		public static boolean getBit(int n, int i) {
		 return ((n & (1 << i)) > 0);
		}

		public static int setBit(int n, int i, boolean isSet) {
		 if (isSet) {
		   return n | (1 << i);
		 } else {
		   return n & ~(1 << i);
		 }
		}

		public static int getBinarySize(int n) {
		       int counter = 0;
			 while(n > 0) {
		          counter++;
			  n = n >> 1;
			 }
			 return counter;
		}

		public static String convertToBinaryString(int n) {
			StringBuilder sb = new StringBuilder();

			 while(n > 0) {
			  if ((n & 1) == 1) {
			   sb.append("1");
			  } else {
			   sb.append("0");
			  }

			  n = n >> 1;
			 }

			 return sb.reverse().toString();
		}

}
