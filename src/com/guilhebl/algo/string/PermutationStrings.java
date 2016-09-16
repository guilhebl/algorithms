package com.guilhebl.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://careercup.com/question?id=5152821373566976
 *
 */
public class PermutationStrings {

	public static void main(String[] args) {
		String[] d1 = {"bad", "actor", "good", "act"};
		String[] d2 = {"bad", "actor", "good", "acting"};
		System.out.println(isPermutation("badactorgoodacting", d1));
		System.out.println(isPermutation("badactorgoodacting", d2));
		
		String[] d1b = {"bad", "good", "actor", "acting", "action"};
		String[] d2b = {"best", "better", "actor", "acting", "movie"};
		System.out.println(isPermutation("badgoodaction", d1b));
		System.out.println(isPermutation("badgoodactionr", d1b));
		System.out.println(isPermutation("betteractingactormovie", d2b));
	}
	
	public static boolean isPermutation(String s, String[] w) {
		Map<Character, List<String>> mapStrings = new HashMap<>();
		for (int i = 0; i < w.length; i++) {
			Character key = Character.valueOf(w[i].charAt(0));
			if (mapStrings.get(key) != null) {
				mapStrings.get(key).add(w[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(w[i]);
				mapStrings.put(key, list);
			}
		}
		return isPermutation(s, 0, new StringBuilder(), mapStrings, new HashSet<>());
	}

	public static boolean isPermutation(String s, int start, StringBuilder t, Map<Character, List<String>> w, HashSet<String> usedStrings) {
		for (int i = start; i < s.length(); i++) {
			if(w.containsKey(s.charAt(i))) {
				List<String> l = w.get(s.charAt(i));
				Iterator<String> iter = l.iterator();
				while (iter.hasNext()) {
					String str = iter.next();
					// if string fits in remaining length 
					if (!usedStrings.contains(str) && str.length() <= s.length() - i && s.substring(i, i + str.length()).equals(str)) { 
						t.append(str);
						usedStrings.add(str);
						if (t.length() == s.length()) {
							return true;
						} else if (t.length() < s.length()) {
							if(isPermutation(s, i + str.length(), t, w, usedStrings)) {
								return true;
							}
						}
						
						// if no match found using this string prefix remove it 
						int lastIndex = s.lastIndexOf(str.charAt(0));
						if (lastIndex != -1 && lastIndex + str.length() <= t.length() &&
								t.substring(lastIndex, lastIndex + str.length()).equals(str)) {
							t.delete(lastIndex, lastIndex + str.length());							
						}						
						usedStrings.remove(str);
					}
				}
			}
		}
		
		return false;
	}
}
