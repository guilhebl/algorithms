package com.guilhebl.algo.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 *
 */
public class MaxKArray {

	public static void main(String[] args) {
		int arr[] = {12, 1, 78, 90, 57, 89, 56};
		printKMax(arr, 3, true);
		printKMax(arr, 3, false);
	}
	
	public static void printKMax(int arr[], int k, boolean isMax) {
		Deque<Integer> d = new ArrayDeque<>(k);
		int i = 0;
		for (; i < k; i++) {
			while (!d.isEmpty() && (isMax && arr[i] >= arr[d.getLast()] || !isMax && arr[i] <= arr[d.getLast()])) {
				d.pollLast();
			}
			d.addLast(i);
		}
		
		List<Integer> list = new ArrayList<>();
		
		for (; i < arr.length; i++) {
			list.add(arr[d.getFirst()]);
			
			while(!d.isEmpty() && d.getFirst() <= (i-k)) {
				d.pollFirst();
			}
			
			while (!d.isEmpty() && (isMax && arr[i] >= arr[d.getLast()] || !isMax && arr[i] <= arr[d.getLast()])) {
				d.pollLast();
			}
			d.addLast(i);			
		}
		list.add(arr[d.getFirst()]);
		
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}		
		System.out.println();
	}
}
