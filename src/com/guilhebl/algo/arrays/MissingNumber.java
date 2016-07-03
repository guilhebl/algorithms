package com.guilhebl.algo.arrays;

public class MissingNumber {

	public static void main(String[] args) {
		
		int[] a = {1,0};
		System.out.println(missingNumber(a));
	}
	
	public static int missingNumber(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        if (nums.length == 1) {
	            if (nums[0] == 1) {
	                return 0;
	            } 
	            return 1;
	        }
	        
	        
	        int i = 0;
	        int num = 0;
	        for(i = 0; i < nums.length; i++) {
	            if (nums[i] != num) {
	                return num;
	            }
	            num++;
	        }
	    
	        return num;
	}
}
