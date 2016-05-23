package com.guilhebl.algo.arrays;

public class ReverseWords {

	public static void main(String[] args) {
		System.out.println(reverseWords("Man bites dog"));
	}
	
	public static String reverseWords(String value) {
		if (value == null || value.equals("")) {
			return null;
		}
		
		String[] words = value.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i] + " ");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
}
