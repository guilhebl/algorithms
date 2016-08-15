package com.guilhebl.algo.string;

/**
 * 
 * https://leetcode.com/problems/ransom-note/
 *
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int cm[] = getCharCountString(magazine);
		int cr[] = getCharCountString(ransomNote);

		for (int i = 0; i < cr.length; i++) {
			if(cm[i] < cr[i]) {
				return false;
			}
		}
		return true;
	}

	private int[] getCharCountString(String magazine) {
		int[] a = new int[256];
		char[] v = magazine.toCharArray();
		for (int i = 0; i < v.length; i++) {
			a[v[i]]++;
		}
		
		return a;
	}
}
