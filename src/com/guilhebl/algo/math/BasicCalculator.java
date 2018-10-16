package com.guilhebl.algo.math;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.trim().equals("")) return 0;

        char[] chars = s.toCharArray();
        int sign = 1;
        int total = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)) {
                int value = Character.getNumericValue(c);
                while(i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    value = value * 10 + Character.getNumericValue(chars[i + 1]);
                    i++;
                }
                total += sign * value;

            } else {
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                } if (c == '(') {
                    deque.push(total);
                    deque.push(sign);
                    sign = 1;
                    total = 0;
                } else if (c == ')') {
                    int lastSign = deque.pop();
                    int lastSum = deque.pop();
                    total = total * lastSign + lastSum;
                }
            }
        }


        return total;
    }
}
