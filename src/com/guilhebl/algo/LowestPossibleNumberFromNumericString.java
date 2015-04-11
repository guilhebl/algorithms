package com.guilhebl.algo;

/**
 * Given a numeric string S (i.e "6205123" ) of size N containing 
 * only digits and a number K where 1 <= K <= N, find the minimum number of possible from deleting K elements 
 * in the string while preserving the original digits orders.
 * @author root
 *
 */
public class LowestPossibleNumberFromNumericString {

	public static void main(String[] args) {
		System.out.println(findLowestPossibleNumberFromNumericString("4205123", 4));
		System.out.println(findLowestPossibleNumberFromNumericString("216504", 3));
		System.out.println(findLowestPossibleNumberFromNumericString("789110110912333", 11));
	}

	public static String findLowestPossibleNumberFromNumericString(String s, int n) {
		if (n <= 0 || s == null || s.length() == 0 || n > s.length()) {
			return null;			
		}
		
		if (s.length() == n) {
			return s;
		}
		
		int[] indexKeep = new int[s.length()];
		int[] numbers = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			numbers[i] = Integer.parseInt(s.substring(i,i+1));
			indexKeep[i] = 0;
		}
						
		int localMin = Integer.MAX_VALUE;
		int localMinIndex = 0;
		int indexStart = 0;		
		int totalCharsToKeep = s.length() - n;
		int indexEnd = s.length() - totalCharsToKeep;
		while (totalCharsToKeep > 0 && indexStart < s.length()) {			
			for (int i = indexStart; i < indexEnd; i++) {				
				if (localMin > numbers[i]) {
					localMin = numbers[i];
					localMinIndex = i;				
				}
			}						
			indexKeep[localMinIndex] = 1;
			totalCharsToKeep--;
			indexStart = localMinIndex + 1;
			indexEnd = s.length() - totalCharsToKeep + 1;
			localMin = Integer.MAX_VALUE;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < indexKeep.length; i++) {
			if (indexKeep[i] == 1) {
				sb.append(numbers[i]);
			}			
		}
				
		return sb.toString();
	}
}