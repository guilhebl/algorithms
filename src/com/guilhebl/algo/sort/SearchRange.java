package com.guilhebl.algo.sort;

/**
 * 
 * https://leetcode.com/problems/search-for-a-range/
 *
 */
public class SearchRange {

	public static void main(String[] args) {
		int[] a = {5, 7, 7, 8, 8, 12};
		int[] r = searchRange(a, 10);
		System.out.print(r[0] + " - " + r[1]);
	}
	
    public static int[] searchRange(int[] nums, int target) {            	    	
        int[] r = new int[2];
        r[0] = r[1] = -1;
        int lastIdxFound = -1;
        
        int idxFound = binarySearch(nums, target, 0, nums.length-1);
        if (idxFound == -1) {
        	return r;
        }
        if (idxFound > 0 && nums[idxFound - 1] == target) {
        	int tempIdx = idxFound;
        	lastIdxFound = idxFound -1;
        	while(tempIdx != -1 && nums[tempIdx] == target) {
        		tempIdx = binarySearch(nums, target, 0, tempIdx-1);
        		lastIdxFound = tempIdx != -1 ? tempIdx : lastIdxFound;
        	}        	
        	r[0] = lastIdxFound;
        } else {
        	r[0] = idxFound;
        }
        if (idxFound < nums.length-1 && nums[idxFound + 1] == target) {
        	int tempIdx = idxFound;
        	lastIdxFound = idxFound +1;
        	while(tempIdx != -1 && nums[tempIdx] == target) {
        		tempIdx = binarySearch(nums, target, tempIdx+1, nums.length-1);
        		lastIdxFound = tempIdx != -1 ? tempIdx : lastIdxFound;
        	}        	
        	r[1] = lastIdxFound;        	
        } else {
        	r[1] = idxFound;
        }        
        
        return r;
    }

	private static int binarySearch(int[] nums, int target, int l, int h) {
    	if (l > h) {
    		return -1;
    	}
    	int mid = (l + h) / 2;
    	if (nums[mid] == target) {
    		return mid;
    	} else if (nums[mid] < target) {
    		return binarySearch(nums, target, mid+1, h);
    	}
    	return binarySearch(nums, target, l, mid-1);
    }
}
