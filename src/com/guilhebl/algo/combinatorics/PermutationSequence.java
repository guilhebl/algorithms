package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/permutation-sequence/
 *
 */
public class PermutationSequence {
	public static void main(String[] args) {
		System.out.println(getPermutation(3, 5));

	}

	public static String getPermutation(int n, int k) {
	    List<Integer> numbers = new ArrayList<>();
	    int[] factorial = new int[n+1];
	    StringBuilder sb = new StringBuilder();
	    
	    int sum = 1;
	    factorial[0] = 1;
	    for(int i=1; i<=n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    for(int i=1; i<=n; i++){
	        numbers.add(i);
	    }
	    k--;
	    
	    for(int i = 1; i <= n; i++){
	        int index = k/factorial[n-i];
	        sb.append(numbers.get(index));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }
	    
	    return String.valueOf(sb);
	}
}

