package com.guilhebl.algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/anagrams/
 *
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		String key = null;
		List<String> listStr = null;
		Map<String, List<String>> mapStrs = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			key = buildAnagramKey(strs[i]);
			if (mapStrs.containsKey(key)) {
				listStr = mapStrs.get(key);
				listStr.add(strs[i]);
			} else {
				listStr = new ArrayList<>();
				listStr.add(strs[i]);
				mapStrs.put(key, listStr);
			}
		}
		
		for(Map.Entry<String, List<String>> e : mapStrs.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}
	
	public static String buildAnagramKey(String key) {
		char[] c = key.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
