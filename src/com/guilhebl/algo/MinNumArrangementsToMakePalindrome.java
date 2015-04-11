package com.guilhebl.algo;


public class MinNumArrangementsToMakePalindrome {
	public static void main(String[] args) {
		System.out.println(findMinNumArrangementsToMakePalindrome("racexyzart"));
		
	}
	
	public static int findMinNumArrangementsToMakePalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		
		int i = 1;
		int n = s.length();
		int maxLenPalindrome = 1;
		String temp = null;
		
		while (i < n) {		
			temp = s.substring(0, i);
			if (isPalindrom(temp)) {
				maxLenPalindrome = temp.length();
			}
			i++;
		}		
		
		return n + (n - maxLenPalindrome);
	}
	
	public static boolean isPalindrom(String s){
		char[] word = s.toCharArray();
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
	
}