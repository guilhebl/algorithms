package com.guilhebl.algo.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://careercup.com/question?id=5637264559308800
 *
 */
public class BiggestWordChain {

	public static void main(String[] args) {
		String[] w = {"a", "b", "ba", "bca", "bda", "bdca"};
		System.out.println(biggestWordChain(w));

		String[] w2 = {"a", "b", "ba", "bca", "bda", "bdca", "bdcaf", "f", "bdcafg", "g", "asdsddsdsa", "xyzxyzyxyz"};
		System.out.println(biggestWordChain(w2));

	}
	
	public static int biggestWordChain(String[] w) {
		int max = 1;
		
		Map<String, Integer> wordCount = new HashMap<>();
		for (int i = 0; i < w.length; i++) {
			wordCount.put(w[i], wordCount.containsKey(w[i]) ? wordCount.get(w[i]) + 1 : 1);
		}
		
		// sort by size - start from bigger strings first - greedy aproach
		Arrays.sort(w, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() > o2.length() ? -1 : o1.length() < o2.length() ? 1 : 0;
			}
		});
		
		for (int i = 0; i < w.length; i++) {
			String s = w[i];			
			if (s.length() > max) {
				int currMax = biggestWordChain(wordCount, new StringBuilder(s));	
				max = Math.max(max, currMax);				
			}
		}
		return max;
	}
	
	public static int biggestWordChain(Map<String,Integer> words, StringBuilder s) {
		int max = 0;
		char[] c = s.toString().toCharArray();
		
		for (int i = 0; i < c.length; i++) {			
			
			// try removing char
			String newStr = null;			
			if (i == 0) {
				newStr = s.substring(i+1);
			} else if (i == c.length-1) {
				newStr = s.substring(0, c.length-1);
			} else {
				newStr = s.substring(0, i) + s.substring(i+1);
			}
			
			if (newStr.equals("")) {
				return 1;
			}
			
			if (words.containsKey(newStr)) {
				max = 1;
				if (words.get(newStr) > 1) {
					words.put(newStr, words.get(newStr) - 1);
				} else {
					words.remove(newStr);
				}
				
				int newMax = 1 + biggestWordChain(words, new StringBuilder(newStr));
				max = Math.max(max, newMax);
				
				// put back attempted string - backtrack
				words.put(newStr, words.containsKey(newStr) ? words.get(newStr) + 1 : 1);				
			}			
		}
		return max;
	}
}
