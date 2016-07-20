package com.guilhebl.algo.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 *
 */
public class MaxProductOfWords {

	public static void main(String[] args) {
		String[] w = {"a","ab","abc","d","cd","bcd","abcd"};
		System.out.println(maxProduct(w));
	}
	
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
        	return 0;
        }

        int prod = 0;
        int maxProd = 0;
    	int lenI = 0;
    	int lenJ = 0;
    	Map<String, Set<Character>> mapChars = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
        	if (!mapChars.containsKey(words[i])) {
        		mapChars.put(words[i], getCharSetWord(words[i]));	
        	}
        	lenI = words[i].length();
        	for (int j = i+1; j < words.length; j++) {
    	        	if (!mapChars.containsKey(words[j])) {
    	        		mapChars.put(words[j], getCharSetWord(words[j]));	
    	        	}
    				
    	        	if (!containsCommonChars(mapChars.get(words[i]), mapChars.get(words[j]))) {    	        		
    	        		lenJ = words[j].length();
    	        		prod = lenI * lenJ;
    	        		maxProd = Math.max(maxProd, prod);
    	        	}	        	    			        		
        	}
		}
    	    	
    	return maxProd;
    }

	private static boolean containsCommonChars(Set<Character> set, Set<Character> set2) {
		for (Character c : set) {
			if (set2.contains(c)) {
				return true;
			}
		}
		return false;
	}

	private static Set<Character> getCharSetWord(String string) {
		
		Set<Character> charSet = new HashSet<>();
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length; i++) {
			charSet.add(c[i]);
		}
		return charSet;
	}
}
