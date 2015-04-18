package com.guilhebl.algo.arrays;

/**
 * find a deterministic shuffle for array, start from an initial order
 * then swap elements in such a way that end state will return initial order.
 * 
 * example:
 * 
 * input:
 * int a[] = {1,2,3,4,6,8} and 2;
 * 
 * output:
 * 
Input: 1 2 3 4 6 8 

Out:
2 1 4 3 8 6 
1 2 3 4 6 8  

input:
 * int a[] = {1,2,3,4,6,8} and 3;
 * 
 * output:
 * 
 * Input: 1 2 3 4 6 8 
 * 
 * Out:
3 1 2 8 4 6 
2 3 1 6 8 4 
1 2 3 4 6 8 
 * 
 * @author root
 *
 */
public class DeterministicShuffleArray {
	
public static void main(String[] args) {
	
	int a[] = {1,2,3,4,6,8};	
	printArray(a);
	shuffle(a, 3);
}		
		
  public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}	
		System.out.println();
  }
		
	public static void shuffle(int[] a, int n) {
		if (n > a.length) {
			return;
		} 		
		int i = 0;
		
		while(i < n) {
			shuffle(a, n, 0, a.length-1);
			printArray(a);
			i++;
		}				
	}

	public static void shuffle(int[] a, int n, int l, int h) {
		for(int i = 0; i < h; i+=n) {
			rotate(a, i, i + n - 1);	
		}
	}

	public static void rotate(int[] a, int l, int h) {
		if (l > h) {
			return;
		}
		int temp = a[l];
		a[l] = a[h];
		a[h] = temp;
		int i = l + 1;
		
		for (; i < h; i++) {
			temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
		}
		
	}

}
