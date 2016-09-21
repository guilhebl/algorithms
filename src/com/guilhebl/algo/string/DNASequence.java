package com.guilhebl.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/repeated-dna-sequences/
 *
 */
public class DNASequence {

	public static void main(String[] args) {
		String s = "AAAAAAAAAAA";
		printList(findRepeatedDnaSequences(s));
	}
		
    private static void printList(List<String> findRepeatedDnaSequences) {
    	for (String string : findRepeatedDnaSequences) {
			System.out.println(string);
		}		
	}

	public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> strs = new ArrayList<>();
    	
    	int k = 10;
    	Map<String, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i <= s.length() - k; i++) {
    		String sub = s.substring(i, i + k);
    		
    		if (map.containsKey(sub)) {
    			map.put(sub, map.get(sub) + 1);
    		} else {
    			map.put(sub, 1);
    		}
    	}
    	
    	for(Map.Entry<String, Integer> e : map.entrySet()) {
    		if (e.getValue() > 1) {
    			strs.add(e.getKey());
    		}
    	}
    	
    	return strs;
    }
	
}
