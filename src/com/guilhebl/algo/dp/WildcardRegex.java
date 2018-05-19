package com.guilhebl.algo.dp;

import java.util.Arrays;

/**
 * https://careercup.com/question?id=6749289161162752
 */
public class WildcardRegex {

    public static void main(String[] args) {
        System.out.println(isMatch("abcd", "a*c++"));
    }

    public static boolean isMatch(String str, String pattern)	{
        int n = str.length();
        int m = pattern.length();

        if (m == 0 && n == 0) return true;

        boolean[][] t = new boolean[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(t[i], false);
        }

        t[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*' || (pattern.charAt(j - 1) == '+')) {
                t[0][j] = t[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (pattern.charAt(j - 1) == '*') {
                    t[i][j] = t[i][j - 1] || t[i - 1][j];
                }
                else if (pattern.charAt(j - 1) == '+') {
                    t[i][j] = t[i][j - 1] || t[i - 1][j - 1];
                }
                else if (str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                }
                else {
                    t[i][j] = false;
                }
            }
        }

        return t[n][m];
    }
}
