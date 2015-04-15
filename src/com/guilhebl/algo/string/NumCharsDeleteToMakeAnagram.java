package com.guilhebl.algo.string;

/**
 * Get Num. chars to delete of both strings in order to make an anagram of 2 strings:
 * 
 * example:
 * 
 * s1 -> aaacdeezzzzz, s2 -> aabbbcef
 * 
 * output> 12
 * 
 * 
 * @author root
 *
 */
public class NumCharsDeleteToMakeAnagram {

    public static void main(String[] args) {
        
    	String s1 = "aaacdeezzzzz";
    	String s2 = "aabbbcef";
    	
    	System.out.println(getNumCharsDeleteToMakeAnagram(s1, s2));
    	
    }

	public static int getNumCharsDeleteToMakeAnagram(String s1, String s2) {
		if (s1 == null || s2 == null || s1.equals("") || s2.equals("")) {
			return -1;
		}
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		if (s1.equals(s2)) {
			return 0;
		}
		
		int[] charCountS1 = new int[26];
		int[] charCountS2 = new int[26];
		int indexOfChar = -1;
		
		char[] sc1 = s1.toCharArray();
		char[] sc2 = s2.toCharArray();
						
		for (int i = 0; i < sc1.length; i++) {
			indexOfChar = sc1[i] - 'a';
			charCountS1[indexOfChar]++;
		}

		for (int i = 0; i < sc2.length; i++) {
			indexOfChar = sc2[i] - 'a';
			charCountS2[indexOfChar]++;
		}

		int numChars = 0;
		for (int i = 0; i < charCountS1.length; i++) {
			if (charCountS1[i] != charCountS2[i]) {
				while (charCountS1[i] > charCountS2[i]) {
					charCountS1[i]--;
					numChars++;
				}

				while (charCountS1[i] < charCountS2[i]) {
					charCountS2[i]--;
					numChars++;
				}
			}
		}
		
		return numChars;
	}
}