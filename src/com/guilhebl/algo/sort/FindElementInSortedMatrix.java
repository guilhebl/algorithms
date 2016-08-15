package com.guilhebl.algo.sort;


/**
 * Find Element in Sorted Matrix
 * @author root
 *
 */
public class FindElementInSortedMatrix {
	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

		System.out.println(getElemInSortedMatrix(a, 20));
	}

	public static int getElemInSortedMatrix(int[][] m, int k) {

		int i = binSearchIndexI(m, k);
		int j = binSearchIndexJ(m, i, k);

		return m[i][j];
	}

	public static int binSearchIndexI(int[][] m, int k) {
		int l = 0;
		int h = m.length;
		int mid = -1;

		while (l < h) {
			mid = l + (h - l) / 2;
			if (m[mid][0] < k) {
				l = mid + 1;
			} else if (m[mid][0] == k) {
				return mid;
			} else if (m[mid][0] > k) {
				h = mid - 1;
			}
		}

		return mid;
	}

	public static int binSearchIndexJ(int[][] m, int i, int k) {
		int l = 0;
		int h = m[0].length;
		int mid = -1;

		while (l < h) {
			mid = l + (h - l) / 2;
			if (m[i][mid] < k) {
				l = mid + 1;
			} else if (m[i][mid] == k) {
				return mid;
			} else if (m[i][mid] > k) {
				h = mid - 1;
			}
		}

		return mid;
	}
}