package com.guilhebl.algo.arrays;

/**
 * in a given int[][] matrix, whenever you find a 0, set all elements to 0 on
 * that row and column
 * 
 * @author root
 *
 */
public class TransformZeroRowColumnMatrix {

	public static void main(String args[]) {
		int n = 4;
		int m[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = i + 1 * j + 1;
			}
		}

		m[2][2] = 0;
		transformZeroRowColumnMatrix(m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void transformZeroRowColumnMatrix(int[][] m) {

		if (m == null || m.length == 0) {
			return;
		}

		int n = m.length;
		boolean[][] v = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j] && m[i][j] == 0) {

					// set row to zero
					for (int r = 0; r < n; r++) {
						m[i][r] = 0;
						v[i][r] = true;
					}

					// set col to zero
					for (int c = 0; c < n; c++) {
						m[c][j] = 0;
						v[c][j] = true;
					}
				}
			}
		}

	}

}
