package com.guilhebl.algo;


/**
 * Get number of Chars to change in order to make an anagram out of String S.
 * 
 * @author root
 *
 */
public class NumCharsToChangeToMakeAnagram {

    public static void main(String[] args) {
    	System.out.println(getNumCharsToChangeToMakeAnagram("xyyx"));
    	System.out.println(getNumCharsToChangeToMakeAnagram("xaxbbbxx"));
    }
    
	public static int getNumCharsToChangeToMakeAnagram(String s) {
		if (s == null || s.equals("") || s.length()%2 != 0) {
			return -1;
		}
		
		int mid = s.length()/2;		
		String s1 = s.substring(0, mid);
		String s2 = s.substring(mid);
		
		if (isAnagram(s1, s2)) {
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
				numChars += Math.abs(charCountS1[i] - charCountS2[i]);
			}
		}
		
		return numChars > 0 ? numChars / 2 : 0;
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
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

		for (int i = 0; i < charCountS1.length; i++) {
			if (charCountS1[i] != charCountS2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
}
