package com.guilhebl.algo.sort;

/**
 * 
 * https://careercup.com/question?id=5737503739871232
 *
 */
public class FindMinMax {

	public static void main(String[] args) {
		int[] a = {2,3,4,5,6,7,10,9,8,7};		
		int[] a2 = {10,9,8,7,6,5,4,3,2};		
		int[] a3 = {1,2,3,4,5,6,7,8};
		int[] a4 = {6,7,8,10,11,12,13,14,15,16,9,8,7,6};
		
		printMinMax(a);
		printMinMax(a2);
		printMinMax(a3);
		printMinMax(a4);
	}
	
	private static void printMinMax(int[] a) {
		int pivot = a.length == 1 || a[0] > a[1] ? 0 : findPivot(a, 0, a.length-1);
		int max = pivot > 0 ? a[pivot-1] : a[0];
		int min = Math.min(a[0], a[a.length-1]);
		System.out.println("max = " + max + ", min = " + min);		
	}

	private static int findPivot(int arr[], int low, int high) {
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}	
}