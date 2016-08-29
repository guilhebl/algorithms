package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/summary-ranges/
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRanges {
	
	public static void main(String[] args) {
		int[] a = {-2,-1,1,2,2147483646,2147483647};
		printList(summaryRanges(a));
	}
	
    private static void printList(List<String> summaryRanges) {
    	for (String string : summaryRanges) {
			System.out.print(string + " ");
		}		
	}

	public static List<String> summaryRanges(int[] nums) {
    	Map<Long, Range> mapRange = new HashMap<>();
    	Range r = null;
    	
    	for (int i = 0; i < nums.length; i++) {
			if (!mapRange.containsKey((long)nums[i])) {
				r = null;
				if (mapRange.containsKey((long)nums[i] - 1)) {
					r = mapRange.get((long)nums[i] - 1);
					if (r.h < nums[i]) {
						r.h = nums[i];
					}					
				}
				if (mapRange.containsKey((long)nums[i] + 1)) {
					r = mapRange.get((long)nums[i] + 1);
					if (r.l < nums[i]) {
						r.l = nums[i];
					}
				}  
				if (r == null) r = new Range((long)nums[i], (long)nums[i]);
				mapRange.put((long)nums[i], r);
			}
		}
    	Set<Long> set = new HashSet<>();
    	List<Range> list = new ArrayList<>();

    	for(Map.Entry<Long, Range> e : mapRange.entrySet()) {    		
    		r = e.getValue();
    		if (!set.contains(r.l)) {    			
    			set.add(r.l);
    			list.add(r);
    		}    		
    	}    	
    	list.sort(new Comparator<Range>() {
    		@Override
    		public int compare(Range o1, Range o2) {
    			if (o1.l < o2.l) {
    				return -1;
    			}
    			else if (o1.l > o2.l) {
    				return 1;
    			} 
    			return new Long(o1.h).compareTo(o2.h);
    		}
    	});
    	List<String> results = new ArrayList<>();
    	for (Range rn : list) {
			if (rn.l != rn.h) {
				results.add(rn.l + "->" + rn.h);	
			} else {
				results.add(new Long(rn.l).toString());
			}    							
		}
    	
    	return results;    			
    }
}
class Range {
	long l;
	long h;
	public Range(long l, long h) {
		super();
		this.l = l;
		this.h = h;
	}	
}
