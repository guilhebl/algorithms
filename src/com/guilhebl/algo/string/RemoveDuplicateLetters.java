package com.guilhebl.algo.string;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 */
public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));	
	}
	
	// bcabc - abc
    public static String removeDuplicateLetters(String s) {
    	if (s == null || s.length() == 1) {
    		return s;
    	}
    	char[] c = s.toCharArray();    	
    	char[] c2 = s.toCharArray();
    	int[] charOccur = new int[26]; 
    	Arrays.fill(charOccur, -1);
    	
    	char temp;
    	int indexChar = -1;
    	int lastIndexChar = -1; 
    	for (int i = 0; i < c.length; i++) {
			temp = c[i];
			indexChar = temp - 'a';
			if (charOccur[indexChar] == -1) {				
				charOccur[indexChar] = i;
				c2[i] = temp;
			} else if (charOccur[indexChar] >= 0) {				
				if (temp == 'a') {
					// keep always first occurrence of a
					c2[i] = '_';
				} else if (temp == 'z') {
					// remove always first occurrence of z
					lastIndexChar = charOccur[indexChar];
					c2[lastIndexChar] = '_';
					c2[i] = temp;
					charOccur[indexChar] = i;
				} else {
					// iterate backwards until we reach last index or smaller char
					lastIndexChar = charOccur[indexChar];
					int j = i - 1;
					char temp2 = c[j];
					while (j >= lastIndexChar && temp2 > temp) {
						j--;
						temp2 = c[j];
					}
					if (j != lastIndexChar && c[lastIndexChar + 1] < c[lastIndexChar]) {
						// reached smaller char - remove first occurence only if lex value gets smaller	
						c2[lastIndexChar] = '_';
						charOccur[indexChar] = i;	
					} else {
						// reached last occurence and no smaller found - keep first
						c2[i] = '_';
					}
				}
			}
		}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < c2.length; i++) {
			if(c2[i] != '_') {
				sb.append(c2[i]);
			}
		}
    	
    	return sb.toString();
    }	
	
}
