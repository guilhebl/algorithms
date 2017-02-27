package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * https://careercup.com/question?id=5707619374202880
 *
 */
public class DictionaryWordCheck {

	public static void main(String[] args) {
		char[] arr = {'e','o','b', 'a','m','g', 'l'}; 

		List<String> strs = new ArrayList<>();
		strs.add("go");
		strs.add("bat");
		strs.add("me");
		strs.add("eat");
		strs.add("goal"); 
		strs.add("boy");
		strs.add("run");
		
		printList(getDictWordsInArray(arr, strs));
	}

	private static void printList(List<String> dictWordsInArray) {
		for (String string : dictWordsInArray) {
			System.out.println(string);
		}
	}

	private static List<String> getDictWordsInArray(char[] arr, List<String> strs) {		
		List<String> results = new ArrayList<>();		
		HashSet<Character> setChars = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			setChars.add(arr[i]);
		}		
		for (String string : strs) {
			char[] chars = string.toCharArray();
			int i = 0;
			while(i < chars.length && setChars.contains(chars[i])) {
				i++;
			}
			if (i == chars.length) {
				results.add(string);
			}
		}
		return results;
	}
	
}
