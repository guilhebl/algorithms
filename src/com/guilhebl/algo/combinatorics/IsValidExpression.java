package com.guilhebl.algo.combinatorics;

import java.util.Stack;

/**
 * https://careercup.com/question?id=5152046306033664
 */
public class IsValidExpression {
    public static void main(String[] args) {
        System.out.println(isValid("aabbab"));
        System.out.println(isValid("abbaab"));
    }

    public static boolean isValid(String expression) {
        if (expression == null || expression.equals("")) {
            return false;
        }
        Stack<Character> opStack = new Stack<>();
        char[] c = expression.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') {
                opStack.push(c[i]);
            } else if (c[i] == 'b') {
                if (opStack.isEmpty() || opStack.peek() != 'a') {
                    return false;
                }
                opStack.pop();
            }
        }

        if (!opStack.isEmpty()) {
            return false;
        }

        return true;
    }
}
