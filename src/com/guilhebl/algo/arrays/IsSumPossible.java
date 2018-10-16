package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSumPossible {

    //Driver program
    public static void main(String args[]) {
        Integer[] a = {1, 2, 3, 4};
        System.out.println(arithmeticBoggle(2,  Arrays.asList(a)));
    }

    public static boolean arithmeticBoggle(
            int magicNumber,
            List<Integer> numbers
    ) {
        if (numbers == null || (magicNumber != 0 && numbers.isEmpty())) return false;
        if (numbers.isEmpty() && magicNumber == 0) return true;
        if (numbers.get(0) != 0 && magicNumber == 0) return false;

        // Fill in the code here
        List<Integer> fullRange = new ArrayList<>();
        for(Integer num : numbers) {
            fullRange.add(num);
            fullRange.add(num * -1);
        }

        // build an array with all negative elements and positive ones
        int[] arr = new int[fullRange.size()];

        int i = 0;
        for(Integer elem: fullRange) {
            arr[i++] = elem;
        }

        Arrays.sort(arr);

        int total = 0;
        for(int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
            total += arr[j];
        }
        if (total == magicNumber) return true;

        int l = 0;
        int r = arr.length;
        int currSum = total;

        while (l < r) {
            if (currSum < magicNumber) {
                if (r < arr.length) currSum += arr[r++];
                else if (arr[l] < 0) currSum -= arr[l++];
                else return false;
            } else if (currSum > magicNumber) {
                if (r >= arr.length) {
                    r = arr.length - 1;
                    currSum -= arr[r];
                } else {
                    int diff = currSum - magicNumber;
                    if (Math.abs(arr[r] - diff) <= Math.abs(arr[l] - diff)) {
                        currSum -= arr[r--];
                    } else {
                        currSum -= arr[l++];
                    }
                }

            } else {
                return true;
            }
        }
        return false;
    }
}
