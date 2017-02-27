package com.guilhebl.algo.string;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaAaaaa"));
	}
	
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }       
        int[] charCount = new int[256];
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
			charCount[c[i]]++;
		}
        
        int countTotal = 0;
        boolean midCharUsed = false;
        for (int i = 0; i < charCount.length; i++) {
        	if (charCount[i] != 0) {
    			if (charCount[i] % 2 == 0) {
    				countTotal += charCount[i]; 
    			} else {
    				countTotal += charCount[i] - 1;
    				if (!midCharUsed) {
    					midCharUsed = true;
    					countTotal ++;					
    				}
    			}        		
        	}
		}
        return countTotal;
    }
}
