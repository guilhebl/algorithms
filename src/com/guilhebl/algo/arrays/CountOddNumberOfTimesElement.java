package com.guilhebl.algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find element that appears odd number of times in array
 * 
 * @author root
 *
 */
public class CountOddNumberOfTimesElement {

	public static void main(String[] args) {
		
		int a[] = {4,7,2,2,5,3,5,7,7,3,4,5,7};
		System.out.println(findNumCountOddTimes(a));
	}
	
	public static int findNumCountOddTimes(int a[]) {
		Map<Integer, Integer> mapCount = new HashMap<>();
		
		for (int i = 0; i < a.length; i++) {
			if (!mapCount.containsKey(a[i])) {
				mapCount.put(a[i], 1);
			} else {
				Integer count = mapCount.get(a[i]);
				count = count + 1;
				mapCount.put(a[i], count);
			}			
		}
		
		for(Map.Entry<Integer, Integer> countEntry : mapCount.entrySet()) {
			if (countEntry.getValue() % 2 != 0) {
				return countEntry.getKey();
			}
		}
		return -1;
	}
}
