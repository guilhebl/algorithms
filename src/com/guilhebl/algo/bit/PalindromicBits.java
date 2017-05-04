package com.guilhebl.algo.bit;

/**
 * https://careercup.com/question?id=5725086158946304
 *
 */
public class PalindromicBits {

	public static void main(String[] args) {
		checkPalindromBits(9);
		checkPalindromBits(8);
		checkPalindromBits(12);
		checkPalindromBits(16);
		checkPalindromBits(32);
		checkPalindromBits(33);
	}
	
	public static void checkPalindromBits(int num) {
		String binaryString = convertToBinaryString(num);
		if (isPalindrome(binaryString.toCharArray())) {
			System.out.println("palindrome");
		} else {
			System.out.println("not palindrome");
		}
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

	public static boolean isPalindrome(char[] c) {	 
		int start = 0;
	    int end = c.length - 1;
	    int mid = (start + end)/2;
	    int i;
	    for (i = start; i <= mid; i++) {
	      if (c[start] == c[end]) {
	        start++;
	        end--;
	      }
	      else {
	        break;
	      }
	    }
	    return (i == mid + 1); 			
	}
}
