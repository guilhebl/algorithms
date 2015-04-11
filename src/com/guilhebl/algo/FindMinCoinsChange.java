package com.guilhebl.algo;
import java.util.Arrays;

/**
 * Find min. number of coins in array necessary to give change of N cents.
 * 
 * Example:
 * coins -> {1, 5, 10, 25};
 * 
 * change: 82
 * 
 * output -> 6 = {25+25+25+5+1+1}
 * 
 * @author root
 *
 */
public class FindMinCoinsChange {

    public static void main(String[] args) {
    	int a[] = {1, 5, 10, 25};
    	System.out.println(findMinNumCoinsSum(82, a));
    }

	public static int findMinNumCoinsSum(int k, int[] arr) {
		int[] t = new int[k + 1];
		
		Arrays.fill(t, 999999);
		t[0] = 0;
		
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] <= i) {					
					t[i] = Math.min(t[i], t[i - arr[j]] + 1);					
				}
			}			
		}
														
		return t[k];
	}


}
