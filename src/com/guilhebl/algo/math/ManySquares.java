package com.guilhebl.algo.math;

import java.util.HashMap;
import java.util.Map;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13277
 *
 */
public class ManySquares {

    public static void main(String[] args) {
		testHowManySquares();
	}
	
	public static void testHowManySquares() {
		int a[] = {1,1,2,2,1,1,2};	
		System.out.println(howManySquares(a));
		
		int b[] = {1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,3,3};
		System.out.println(howManySquares(b));
	}
	
	public static int howManySquares(int[] sticks) {
		Map<Integer, Integer> mapCounts = new HashMap<>();
		int count = 0, totalCount = 0;
		for (int i = 0; i < sticks.length; i++) {
			if(mapCounts.containsKey(sticks[i])) {
				count = mapCounts.get(sticks[i]);
				count++;
				mapCounts.put(sticks[i], count);
			} else {
				mapCounts.put(sticks[i], 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : mapCounts.entrySet()) {
			totalCount += entry.getValue() / 4;
		}
		return totalCount;
	}
}