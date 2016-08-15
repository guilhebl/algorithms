package com.guilhebl.algo.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/contains-duplicate/
 * https://leetcode.com/problems/contains-duplicate-ii/
 * https://leetcode.com/problems/contains-duplicate-iii/
 *
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] a = {1,3,1};
		int k = 1;
		int t = 1;
		
		ContainsDuplicate cd = new ContainsDuplicate();
		System.out.println(cd.containsNearbyAlmostDuplicate(a, k, t));
	}
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> setInt = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (setInt.contains(nums[i])) {
                return true;
            } else {
                setInt.add(nums[i]);
            }
        }
        return false;
    }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer, Integer> mapIdxs = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	if (mapIdxs.containsKey(nums[i])) {
        		int j = mapIdxs.get(nums[i]);
        		if (Math.abs(i - j) <= k) {
        			return true;
        		}
        	}        		
        	mapIdxs.put(nums[i], i);
        }
        return false;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (k < 1 || t < 0) {
    		return false;
    	}
    	
    	Map<Long, Long> map = new HashMap<>();
    	int i = 0;
    	for(i = 0; i < nums.length; i++) {
    		long elem = (long) nums[i] - Integer.MIN_VALUE;
    		long bucket = elem / ((long) t + 1);
    		if (map.containsKey(bucket) ||
    			(map.containsKey(bucket - 1) && 
    					elem - map.get(bucket - 1) <= t) ||
    			(map.containsKey(bucket + 1) && 
    			 	map.get(bucket + 1) - elem <= t)) {
    			return true;    				    			
    		} 
    		if (i >= k) {
    			map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) (t + 1))); 
    		}
    		map.put(bucket, elem);
        }
        return false;        
    }
    
}