package com.guilhebl.algo.string;

/**
 * 
 * https://careercup.com/question?id=5744080144302080
 *
 */
public class PrintCountString {

	public static void main(String[] args) {
		String s = "abbaccdbac";
		
		printOccurencesChars(s);
	}

	// assuming only ASCII chars in string.
	private static void printOccurencesChars(String s) {

		int[] count = new int[256];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		char[] c = s.toCharArray();
		int charVal = -1;
		for (int i = 0; i < c.length; i++) {
			charVal = (int) c[i];
			count[charVal]++;
		}
		
		StringBuilder sb = new StringBuilder();
		int charCount = -1;
		for (int i = 0; i < count.length; i++) {
			charCount = count[i];
			if (charCount > 0) {
				sb.append((char)i + "" + charCount);
			}			
		}
		
		System.out.println(sb.toString());
	}
}
