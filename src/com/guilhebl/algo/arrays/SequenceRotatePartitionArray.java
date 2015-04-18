package com.guilhebl.algo.arrays;

/**
 * partition array and swap elements N times shifting them to the right in a circular array manner, 
 * start from an initial sorted order array then swap elements in such a way that end state will be the same as initial 
 * order afting calling function N times.
 * 
 * example:
 * 
 * input:
 * int a[] = {1,2,3,4,6,8} and 2;
 * 
 * shuffle(a, 2);
 * 
 * output:
 * 
2 1 4 3 8 6 
1 2 3 4 6 8  

input:
 * int a[] = {1,2,3,4,6,8} and 3;
 * 
 * shuffle(a, 3);
 * 
 * output:
 * 
3 1 2 8 4 6 
2 3 1 6 8 4 
1 2 3 4 6 8 
 * 
 * 
 * 
 * @author root
 *
 */
public class SequenceRotatePartitionArray {
	
public static void main(String[] args) {
	
	int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};	
	printArray(a);
	shuffle(a, 2);
	System.out.println();
	
	int b[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};	
	printArray(b);
	shuffle(b, 5);
	System.out.println();
	
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
