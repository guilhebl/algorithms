package com.guilhebl.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Find longest substring with "m" unique characters in a given string.
 * 
 * input: aabacbeabbed output: 4 (aaba) for 2 unique characters 6 (aabacb) for 3
 * unique characters
 * 
 * @author root
 *
 */
public class FindLongestSubstringWithUniqueChars {

	public static void main(String[] args) {
		System.out.println(findLongestSubstringMUniqueChars("aabacbeabbed", 2));
		System.out.println(findLongestSubstringMUniqueChars("aabacbeabbed", 3));
	}
	
	public static String findLongestSubstringMUniqueChars(String s,
			int maxUniques) {
		if (s == null || s.length() == 0 || s.length() < maxUniques) {
			return null;
		}

		if (s.length() == maxUniques) {
			return s;
		}

		int currentCharCount = 0;
		int currentUniqueCharCount = 0;
		int longestCharCount = 0;
		int longestIndexInit = 0;
		int longestIndexEnd = 0;

		Set<Character> currentSet = new HashSet<>();

		char[] chars = s.toCharArray();

		int i = 0;
		while (i < chars.length) {
			Character c = chars[i];
			if (currentUniqueCharCount < maxUniques) {
				if (!currentSet.contains(c)) {
					currentSet.add(c);
					currentUniqueCharCount++;
				}
				currentCharCount++;

			} else if (currentUniqueCharCount == maxUniques) {
				if (!currentSet.contains(c)) {
					if (longestCharCount < currentCharCount) {
						longestCharCount = currentCharCount;
						longestIndexInit = i - currentCharCount;
						longestIndexEnd = i;
					}

					currentSet = new HashSet<>();
					i = i - currentCharCount;
					currentCharCount = 0;
					currentUniqueCharCount = 0;

				} else {
					currentCharCount++;
				}
			}
			i++;
		}

		if (longestCharCount < currentCharCount) {
			longestCharCount = currentCharCount;
			longestIndexInit = i - currentCharCount;
			longestIndexEnd = s.length() - 1;
		}

		return s.substring(longestIndexInit, longestIndexEnd);
	}
}
