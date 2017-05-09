package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://careercup.com/question?id=5708190613241856
 * @author gui
 *
 */
public class TaskCountString {

	public static void main(String[] args) {
		System.out.println(rearrangeTasks("AAABBBCCC", 3));		
		System.out.println(rearrangeTasks("AAABC", 2));
		System.out.println(rearrangeTasks("AAADBBCC", 2));
	}
	
	public static int rearrangeTasks(String s, int k) {
		
		List<Character> listC = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
		    listC.add(c);
		}

		// create a map of each char as key and its count num. of occurences in string 
		Map<Character, Long> mapCount = listC.stream()
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		int i = 0;
		int numChars = s.length();
		
		StringBuilder sb = new StringBuilder();	
		Deque<Character> deque = new LinkedList<>(); // use a deque to keep track of last used chars
		int totalCost = 0;
		
		while(i < numChars) {			
			Tuple<Character,Integer> t = getMaxCount(mapCount, deque, k);			
			sb.append(t.x);
			totalCost += t.y;
			deque.addLast(t.x);
			long countOfChar = mapCount.get(t.x); 			
			if (countOfChar == 1) {
				mapCount.remove(t.x);
			} else {
				mapCount.put(t.x, countOfChar - 1);
			}
			if (deque.size() > k) {
				deque.removeFirst();
			}			
			i++;
		}
				
		System.out.println(sb);		
		return totalCost;
	}

	private static Tuple<Character,Integer> getMaxCount(Map<Character, Long> mapCount, Deque<Character> deque, int k) { 	
		long max = 0;
		Character maxChar = null;		
		Map<Character, Long> mapCopy = new HashMap<>(mapCount);
		
		for(Character c : deque) {
			mapCopy.remove(c);
		}
		
		if (!mapCopy.isEmpty()) {
			for(Map.Entry<Character, Long> e : mapCopy.entrySet()) {
				if (e.getValue() > max) {
					max = e.getValue();
					maxChar = e.getKey();
				}
			}			
			return new Tuple<>(maxChar, 1);
		}				
		int cost = 2;
		for(Character c : deque) {
			if (mapCount.get(c) != null)
				return new Tuple<>(c, cost);
			cost++;
		}
		
		return null;
	}	
}
class Tuple<X, Y> { 
	  public final X x; 
	  public final Y y; 
	  public Tuple(X x, Y y) { 
	    this.x = x; 
	    this.y = y; 
	  } 
} 

