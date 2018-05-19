package com.guilhebl.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 */
class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.trim().equals("")) return -1;

        boolean[] found = new boolean[256];
        char[] c = s.toCharArray();
        Map<Character, Integer> m = new HashMap();

        for (int i = 0; i < c.length; i++) {
            int idx = c[i] - 'a';
            Character ch = new Character(c[i]);
            if (!found[idx]) {
                found[idx] = true;
                m.put(ch, i);
            } else if (m.containsKey(ch)) {
                m.remove(ch);
            }
        }

        if (m.isEmpty()) {
            return -1;
        }

        int min = s.length()-1;
        for (Map.Entry<Character, Integer> e : m.entrySet()) {
            min = Math.min(min, e.getValue());
        }

        return min;
    }
}
