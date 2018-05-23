package com.guilhebl.algo.combinatorics;

import java.util.Stack;

/**
 *
 * Given index i,j
 *
 * Find max subsequence of valid params such as : ())(())(())( from (0, 11) -> Max = 10 ()(())(())
 *
 * This is an O(n) solution, for a O(logN) solution, check:
 *
 * https://www.geeksforgeeks.org/range-queries-longest-correct-bracket-subsequence/
 */
public class MaxValidParensLength {
    public static void main(String[] args) {
        System.out.println(lenMaxParens("())(())(())(", 0, 11));
    }

    public static int lenMaxParens(String expression, int start, int end) {
        if (start > end || start < 0 || start >= expression.length() || end > expression.length()) {
            return 0;
        }

        Stack<Character> opStack = new Stack<>();
        char[] c = expression.toCharArray();
        int size = 0;

        for (int i = start; i < end; i++) {
            if (c[i] == '(') {
                opStack.push('(');
                size++;
            } else if (c[i] == ')') {
                if (!opStack.isEmpty() && opStack.pop() == '(') {
                    size++;
                }
            }
        }

        while (!opStack.isEmpty()) {
            opStack.pop();
            size--;
        }

        return size;
    }

}
