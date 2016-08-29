package com.guilhebl.algo.string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * https://leetcode.com/problems/largest-number/
 *
 */
public class LargestNumber {
	
	public static void main(String[] args) {
		int[] a = {824,938,1399,5607,6973,5703,9609,4398,8247};
		System.out.println(largestNumber(a));
	}
	
    public static String largestNumber(int[] nums) {
    	StringBuilder s = new StringBuilder();
    	PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {

    		@Override
    		public int compare(String o1, String o2) {
    			if (o1.equals(o2)) return 0;    			
    			int i1 = 0;
    			int i2 = 0;
    			int n1 = 0;
    			int n2 = 0;
    			while(i1 < o1.length() && i2 < o2.length()) {
    				n1 = Integer.parseInt(new Character(o1.charAt(i1)).toString()); 
    				n2 = Integer.parseInt(new Character(o2.charAt(i2)).toString());
    				if (n1 < n2) return 1;
    				else if (n1 > n2) return -1;    				    				    				
    				i1++;
    				i2++;
    			}
    			while(i1 < o1.length()) {
    				n1 = Integer.parseInt(new Character(o1.charAt(i1)).toString());    				
    				if (n1 < n2) return 1;
    				else if (n1 > n2) {
    					int firstDigitN2 = Integer.parseInt(new Character(o2.charAt(0)).toString());
    					return n1 > firstDigitN2 ? -1 : 1;
    				}
    				i1++;
    			}
    			while(i2 < o2.length()) {
    				n2 = Integer.parseInt(new Character(o2.charAt(i2)).toString());    				
    				if (n1 > n2) return -1;
    				else if (n2 > n1) {
    					int firstDigitN1 = Integer.parseInt(new Character(o1.charAt(0)).toString());
    					return n2 > firstDigitN1 ? 1 : -1;    					    				    				    				
    				}
    				i2++;
    			}
    			
    			return 0;
    		}
    	});

    	for (int i = 0; i < nums.length; i++) {			    		
    		q.add(new Integer(nums[i]).toString());    		
		}

    	while(!q.isEmpty()) {
    		s.append(q.poll());
    	}
    	if (s.charAt(0) == '0' && s.charAt(s.length()-1) == '0') return "0";    	
    	return s.toString();
    }
}
