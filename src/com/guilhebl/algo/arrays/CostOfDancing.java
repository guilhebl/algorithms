package com.guilhebl.algo.arrays;

import java.util.Random;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13195
 *
 */
public class CostOfDancing {

		public static void main(String[] args) {
			solveCostOfDancing();
		}
		
		public static void solveCostOfDancing() {

			int[] dc = {1, 5, 3, 4};
			System.out.println(minimumDances(2, dc));

			int[] dc2 = {1, 5, 4};
			System.out.println(minimumDances(3, dc2));

			int[] dc3 = {2, 2, 4, 5, 3};
			System.out.println(minimumDances(1, dc3));

			int[] dc4 = {973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932,
					 703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801};
			System.out.println(minimumDances(39, dc4));				
		}

		public static void solveKthSmallest() {
			Integer[] a = {12, 3, 17, 0, 9, 6, 100};
			
			int k = 3;
			System.out.println(quickSelect(a, k-1, 0, a.length-1));
		}

		public static int minimumDances(int k, int[] dc) {
			int i = 0;
			int sum = 0;
			Integer[] dcs = new Integer[dc.length];
			for (int j = 0; j < dcs.length; j++) {
				dcs[j] = dc[j];
			}		

			while (i < k) {
				sum += quickSelect(dcs, i, i, dc.length-1);
				i++;
			}
			return sum;
		}
		
		private static <E extends Comparable<? super E>> int partition(E[] arr,
				int left, int right, int pivot) {
			E pivotVal = arr[pivot];
			swap(arr, pivot, right);
			int storeIndex = left;
			for (int i = left; i < right; i++) {
				if (arr[i].compareTo(pivotVal) < 0) {
					swap(arr, i, storeIndex);
					storeIndex++;
				}
			}
			swap(arr, right, storeIndex);
			return storeIndex;
		}

		private static <E extends Comparable<? super E>> E quickSelect(E[] arr,
				int n, int left, int right) {
			Random rand = new Random();
			while (right >= left) {
				int pivotIndex = partition(arr, left, right,
						rand.nextInt(right - left + 1) + left);
				if (pivotIndex == n) {
					return arr[pivotIndex];
				} else if (pivotIndex < n) {
					left = pivotIndex + 1;
				} else {
					right = pivotIndex - 1;
				}
			}
			return null;
		}

		private static void swap(Object[] arr, int i1, int i2) {
			if (i1 != i2) {
				Object temp = arr[i1];
				arr[i1] = arr[i2];
				arr[i2] = temp;
			}
		}
		
}
