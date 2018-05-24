package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://careercup.com/question?id=5629693913989120
 */
public class CheckBitPermutationInString {

    public static void main(String[] args) {
        System.out.println(isValid("11001", 2));
    }

    public static boolean isValid(String s, int k) {
        List<String> l = getAllBinarySubsets(k);
        for (String binary : l) {
            if (s.indexOf(binary) == -1) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getAllBinarySubsets(int k) {
        List<String> list = new ArrayList<>();
        String format = "%0" + k + "d";

        for(int i = 0; i < Math.pow(2, k); i++) {
            list.add(String.format(format, Integer.valueOf(Integer.toBinaryString(i))));
        }
        return list;
    }
}
