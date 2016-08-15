package com.guilhebl.algo.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
	
	public static void main(String[] args) {		
		String[] s = new String[3];		
		s[0] = "ssbcddeeggghhererete";
		s[1] = "ssbcddeeggghhxeqqwqeqwe";
		s[2] = "ssbcddeeggghhxeq412qwqeqweaw123oi";
		LongestCommonPrefix lp = new LongestCommonPrefix();
		System.out.println(lp.longestCommonPrefix(s));		
	}
	
	public String longestCommonPrefix(String[] strs) {
	        if (strs == null)  return null;        
	        if (strs.length == 0 || (strs.length > 0 && strs[0].equals(""))) {return "";}
	        if (strs.length == 1) {return strs[0];}                
	        boolean hasMore = true;
	        int i = 0, j;
	        char prevChar = strs[0].charAt(0), c = prevChar;
	        StringBuilder sb = new StringBuilder();
	        while (hasMore) {
	        	if (i >= strs[0].length()) {
	        		hasMore = false;
	        	} else {
	        		prevChar = strs[0].charAt(i);
	        	}
	        	for (j = 1; j < strs.length && hasMore; j++) {
	            	if (i >= strs[j].length()) {
	            		hasMore = false;
	            	} else {
	            		c = strs[j].charAt(i);
	            		if (c != prevChar) {
	            			return sb.toString();
	            		}             		
	            	}	
	        	}
	        	if (hasMore) sb.append(c);
	        	i++;
	        }
	        return sb.toString();
	    }
}
