package com.guilhebl.algo.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LargestContiguousDistinctSubarray {

	
	public static void main(String[] args) {
		int[] a = {2,4,6,8,3,4,2,6,8,3};
		System.out.println(longest(a));
	}
	
	
	public static int longest(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int max = 0;
		int currMax = 0;
		int nextIndex = 0;
		
		Map<Integer, Integer> mapCount = null;
		
		int j = 0;
		for (int i = 0; i < a.length - 1; i++) {
			j = i + 1;
			mapCount = new HashMap<>();
			mapCount.put(a[i], 0);
			currMax = 1;
			
			while(j < a.length && !mapCount.containsKey(a[j])) {
				currMax++;
				mapCount.put(a[j], j);
				j++;
			}			
			max = Math.max(max, currMax);
			
			nextIndex = mapCount.get(a[j]) + 1;
			if (nextIndex >= a.length) {
				nextIndex = i + 1;	
			} 
			i = nextIndex;
		}
						
		return max;		
	}
	
	
	public static int longestSubarray(int[] arr) {
	    int i = 0, j = 1, max = 0, currLength = 1;
	    HashSet<Integer> set = new HashSet<Integer>();
	    set.add(arr[0]);

	    while (i < arr.length - 1 && j < arr.length) {
	        if (!set.contains(arr[j])) {
	            currLength++;
	            set.add(arr[j++]);
	        }
	        else {
	            max = Math.max(max, currLength);
	            set.remove(arr[i++]);
	            currLength--;
	        }
	    }

	    return Math.max(currLength, max);
	}
}
