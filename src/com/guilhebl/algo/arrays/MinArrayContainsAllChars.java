package com.guilhebl.algo.arrays;

import java.util.Arrays;

public class MinArrayContainsAllChars {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.equals("")) return 0;

        int i = 0, j = 0, count = 0, max = 0;
        int[] map = new int[128];
        Arrays.fill(map, 0);

        while(j < s.length()) {
            if(map[s.charAt(j++)]++ == 0) count++;
            while(count > 2) {
                if (map[s.charAt(i++)]-- == 1) count--;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";

        int[] chars = new int[128];

        for (Character c : t.toCharArray()) {
            chars[c]++;
        }

        int i = 0;
        int j = 0;
        int d = Integer.MAX_VALUE;
        int minI = 0;
        int count = t.length();

        while (j < s.length()) {
            if (chars[s.charAt(j++)]-- > 0) count--;
            while ( count == 0 ) {
                if (j - i < d) {
                    d = j - i;
                    minI = i;
                }
                if (chars[s.charAt(i++)]++ == 0)
                    count++;
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(minI, minI + d);
    }

    public static void main(String[] args) {
        MinArrayContainsAllChars m = new MinArrayContainsAllChars();
        System.out.println(m.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
