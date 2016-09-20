package com.guilhebl.algo.string;

/**
 * 
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 */
public class LongestSubstringMaxKRepeat {

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb", 3));
		System.out.println(longestSubstring("ababbc", 2));
		System.out.println(longestSubstring("aba", 2));
		System.out.println(longestSubstring("bbaaacbd", 3));
		System.out.println(longestSubstring("ababbcdefgddeeffgg", 2));
	}
	
    public static int longestSubstring(String s, int k) {
            int n = s.length();
            if (n==0 || n<k) return 0;
            if (k==1) return n;
            int[] counts = new int[26];
            for (char c: s.toCharArray()) counts[c-'a']++;          
            char invalidChar = 0;
            boolean found = false;
            for (int i=0; i<26 && !found; i++) {
                if (counts[i]>0 && counts[i]<k) {
                    invalidChar = (char)(i+'a');
                    found = true;
                }
            }
            if (!found) return n;
            String[] subs = s.split(invalidChar+"");
            int res = 0;
            for (String sub:subs) res = Math.max(res, longestSubstring(sub,k));
            return res;
     }	
}
