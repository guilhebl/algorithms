package com.guilhebl.algo.string;

/**
 * 
 * https://leetcode.com/problems/compare-version-numbers/
 *
 */
public class CompareVersionNumbers {


	public static void main(String[] args) {
		//System.out.println(compareVersion("0.1", "1.0"));
		System.out.println(compareVersion("1.0", "1"));
	}
	
	public static int compareVersion(String version1, String version2) {
    	
    	int i1 = 0;
    	int i2 = 0;
    	int i1Num = 0;
    	int i2Num = 0;
    	
    	while(i1 < version1.length() && i2 < version2.length()) {
    		int i1DotIndex = version1.indexOf('.', i1);
    		if (i1DotIndex == -1) {
    			i1Num = Integer.parseInt(version1.substring(i1, version1.length()));
    			i1 = version1.length();
    		} else {
    			i1Num = Integer.parseInt(version1.substring(i1, i1DotIndex));
    			i1 = i1DotIndex + 1;
    		}
    		    		
    		int i2DotIndex = version2.indexOf('.', i2);
    		if (i2DotIndex == -1) {
    			i2Num = Integer.parseInt(version2.substring(i2, version2.length()));
    			i2 = version2.length();
    		} else {
    			i2Num = Integer.parseInt(version2.substring(i2, i2DotIndex));
    			i2 = i2DotIndex + 1;
    		}
    		
    		if (i1Num < i2Num) {
    			return -1;
    		} else if (i1Num > i2Num) {
    			return 1;
    		}    		
    	}    	

    	while(i1 < version1.length()) {
    		int i1DotIndex = version1.indexOf('.', i1);
    		if (i1DotIndex == -1) {
    			i1Num = Integer.parseInt(version1.substring(i1, version1.length()));
    			i1 = version1.length();
    		} else {
    			i1Num = Integer.parseInt(version1.substring(i1, i1DotIndex));
    			i1 = i1DotIndex + 1;
    		}
    		if (i1Num > 0) return 1;    		
    	}
    	while(i2 < version2.length()) {
    		int i2DotIndex = version2.indexOf('.', i2);
    		if (i2DotIndex == -1) {
    			i2Num = Integer.parseInt(version2.substring(i2, version2.length()));
    			i2 = version2.length();
    		} else {
    			i2Num = Integer.parseInt(version2.substring(i2, i2DotIndex));
    			i2 = i2DotIndex + 1;
    		}
    		if (i2Num > 0) return -1;
    	}    	
    	return 0;        
    }

}
