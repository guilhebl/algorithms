package com.guilhebl.algo.bit;

/**
 * 
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 */
public class SumTwoNumbers {
    public int getSum(int a, int b) {
        int r = a ^ b;
        int carry = (a & b) << 1;
        int a2 = r;
        int b2 = carry;

        while(carry > 0) {
            r = a2 ^ b2;
            carry = (a2 & b2) << 1;
            a2 = r;
            b2 = carry;
        }
        return r;
    }
}
