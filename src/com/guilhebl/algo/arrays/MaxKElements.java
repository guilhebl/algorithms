package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxKElements {
	
	public static void main(String[] args) {
		testSolution();
	}

	public static void testSolution() {
		int a[] = {1,1,1,2,2,3};				
		int k = 2;
		
		MaxKElements mk = new MaxKElements();
		List<Integer> r = mk.topKFrequent(a, k);
		
		for (Integer i : r) {
			System.out.print(i);
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
	        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
	          return null;   
	        }
	        
	        Map<Integer, Integer> mapCount = new HashMap<>();
	        
	        int count = 0;
	        PriorityQueue<IntCount> pq = new PriorityQueue<IntCount>(nums.length, new IntComparator());	        
	       
	        for (int i = 0; i < nums.length; i++) {
	        	if (!mapCount.containsKey(nums[i])) {
	        		mapCount.put(nums[i], 1);
	        	} else {
	        		count = mapCount.get(nums[i]); 
	        		mapCount.put(nums[i], count+1);
	        	}	            	        	           
	        }	        	       
	        for(Map.Entry<Integer, Integer> e : mapCount.entrySet()) {
	        	pq.add(new IntCount(e.getKey(), e.getValue()));
	        }
	        List<Integer> topFreq = new ArrayList<>();
	        for (int i = 0; i < k; i++) {
	        	topFreq.add(pq.poll().num);
	        }
	        
	        return topFreq;
	}
	
	class IntCount {
		Integer num;
		Integer count;
		public IntCount(Integer num, Integer count) {
			super();
			this.num = num;
			this.count = count;
		}				
	}
	
	class IntComparator implements Comparator<IntCount>{
		@Override
		public int compare(IntCount o1, IntCount o2) {
			return o1.count.compareTo(o2.count) * -1;
		}
	}

}
