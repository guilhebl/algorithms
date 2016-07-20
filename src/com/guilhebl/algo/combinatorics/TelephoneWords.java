package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneWords {

	public static void main(String[] args) {
		printList(letterCombinations("23"));
	}
	public static void printList(List<String> s) {
		for (String string : s) {
			System.out.println(string);
		}
	}
	
	public static List<String> letterCombinations(String digits) {
		if (digits == null) {
			return null;
		}
		List<String> r = new ArrayList<>();
		if (digits.equals("")) {
			return r;
		}
		
		int nums[] = new int[digits.length()];
		char[] c = digits.toCharArray();
		for (int i = 0; i < c.length; i++) {
			nums[i] = Integer.parseInt(new Character(c[i]).toString());
		}
			  
	    Map<Integer, String> mapChars = new HashMap<>();
	    mapChars.put(2, "abc");
	    mapChars.put(3, "def");
	    mapChars.put(4, "ghi");
	    mapChars.put(5, "jkl");
	    mapChars.put(6, "mno");
	    mapChars.put(7, "pqrs");
	    mapChars.put(8, "tuv");
	    mapChars.put(9, "wxyz");
	    
	    char[] chars = new char[nums.length];
	    generatePhoneWords(r, nums, mapChars, chars, 0);
	    return r;
	}
	
	public static void generatePhoneWords(List<String> r, int[] nums, Map<Integer, String> numsToWords, char[] c, int i) {
		if (i == nums.length) {
			r.add(new String(c));
		} else if (i < nums.length) {
			if (!numsToWords.containsKey(nums[i])) {
				c[i] = new Integer(nums[i]).toString().charAt(0);
				generatePhoneWords(r, nums, numsToWords, c, i + 1);
			}
			else {
				for (int j = 0; j < numsToWords.get(nums[i]).length(); j++) {
					c[i] = (numsToWords.get(nums[i]).charAt(j));
					generatePhoneWords(r, nums, numsToWords, c, i + 1);
				}				
			}
		}
	}

}
