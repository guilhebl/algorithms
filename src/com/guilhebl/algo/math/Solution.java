package com.guilhebl.algo.math;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		System.out.println(palindrome("aabaa"));
	}
	
	static int palindrome(String str) {
		if (str == null || str.length() == 0)
			return 0;

		Map<String, Integer> map = new HashMap<>();
		int len = str.length();

		int[][] sol = new int[2][len + 1];
		String s = "@" + str + "#";
		char[] c = s.toCharArray();

		for (int j = 0; j <= 1; j++) {
			int rp = 0;
			sol[j][0] = 0;

			int i = 1;
			while (i <= len) {
				while (c[i - rp - 1] == c[i + j + rp]) {
					rp++;
				}

				sol[j][i] = rp;

				int k = 1;
				while ((sol[j][i - k] != rp - k) && (k < rp)) {
					sol[j][i + k] = Math.min(sol[j][i - k], rp - k);
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}

		s = s.substring(1, len+1);
		map.put(new Character(s.charAt(0)).toString(), 1);

		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= 1; j++) {
				for (int rp = sol[j][i]; rp > 0; rp--) {
					int subStartIdx = i - rp - 1;
					int subEndIdx = subStartIdx + (2*rp) + j;
					subEndIdx = subEndIdx > len ? len : subEndIdx; 
					map.put(s.substring(subStartIdx, subEndIdx), 1);
				}
			}
			map.put(new Character(s.charAt(i)).toString(), 1);
		}

		return map.size();
	}
	  
	//abcde
    static int frequent(String s, int k, int l, int m) {
    	if (s == null || s.equals("")) return 0;
    	int len = s.length();
    	int numChars = k;
    	int maxOccur = 0;
    	int currMax = 0;
    	int lastMax = -1;
    	
    	Map<String, Integer> mapCount = new HashMap<>();
    	
    	while(numChars <= l) {
    		currMax = -1;
        	for (int i = 0; (i + numChars-1) < len; i++) {
    			String sub = s.substring(i, i + numChars);    			
    			if (getCharCountUnique(sub) <= m) {
    				int count = 1;
            		if (mapCount.containsKey(sub)) {
            			count = mapCount.get(sub);
            			count = count + 1;
            			mapCount.put(sub, count);
            		} else {
            			mapCount.put(sub, count);
            		}            		
            		maxOccur = Math.max(maxOccur, count);
            		currMax = Math.max(currMax, count);
    			}    			
    		}        	
        	if (lastMax != -1 && lastMax > currMax) {
        		numChars = l+1; // stop searching
        	}
        	lastMax = currMax;    		    		
        	numChars++;
    	}
    	return maxOccur;
    }

	private static int getCharCountUnique(String s) {
		int[] a = new int[256];
		int unique = 0;
		char[] v = s.toCharArray();
		for (int i = 0; i < v.length; i++) {
			if (a[v[i]] == 0) {
				unique++;
			} else if (a[v[i]] > 0) {
				unique--;
			}
			a[v[i]]++;
		}		
		return unique;
	}

	private int[] getCharCountString(String s) {
		int[] a = new int[256];
		char[] v = s.toCharArray();
		for (int i = 0; i < v.length; i++) {
			a[v[i]]++;
		}
		
		return a;
	}

}
