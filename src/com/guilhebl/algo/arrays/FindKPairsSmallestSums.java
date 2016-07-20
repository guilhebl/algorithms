package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 */
public class FindKPairsSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> r = new ArrayList<>();
    	if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
        	return r;
        }        
    	PriorityQueue<PairSum> q = new PriorityQueue<>(new Comparator<PairSum>() {
    		@Override
    		public int compare(PairSum o1, PairSum o2) {
    			return o1.sum.compareTo(o2.sum);
    		}
    	});
               
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
            	q.add(new PairSum(nums1[i], nums2[j], nums1[i] + nums2[j]));
    		}
		}
        
        int[] arr = null;
        int count = 0;
        while (count < k && !q.isEmpty()) {
        	PairSum s = q.poll();
        	arr = new int[2];
        	arr[0] = s.a;
        	arr[1] = s.b;
        	r.add(arr);
        	count++;
        }
 
        return r;
    }

}

class PairSum {
	Integer a;
	Integer b;
	Integer sum;
	public PairSum(int a, int b, int sum) {
		super();
		this.a = a;
		this.b = b;
		this.sum = sum;
	}
}