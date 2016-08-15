package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 *
 */
public class ShuffleArray {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		ShuffleArray s = new ShuffleArray(a);
		int[] b=s.shuffle();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");			
		}
	}
	
	private int[] bckup;
	
	public ShuffleArray(int[] nums) {
		bckup = copyArray(nums);
	}
	
	public int[] copyArray(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
		return a;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return bckup;
	}

	/** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] a = new int[bckup.length];
    	if (bckup.length == 0) {
    		return a; 
    	} 
    	List<Integer> idxs = new ArrayList<>();
    	for (int i = 0; i < bckup.length; i++) {
			idxs.add(i);
		}
    	
    	int j = 0;
    	while (idxs.size() > 1) {
    		Random random = new Random(System.currentTimeMillis());
    		int idx = idxs.remove(random.nextInt(idxs.size()));
    		a[j++] = bckup[idx];
    	}
    	a[j] = bckup[idxs.get(0)];            	
    	return a;
    }
}