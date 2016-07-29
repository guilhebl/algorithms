package com.guilhebl.algo.arrays;

/**
 * 
 * https://careercup.com/question?id=5763139615326208
 *
 */
public class Toepliz {

	public static void main(String[] args) {
		int[][] m = {
				{6,7,8,9,2},
				{4,6,7,8,9},
				{1,4,6,7,8},
				{0,1,4,6,7}
		};
		
		System.out.println(isToepliz(m));
		
		int[][] m2 = {
				{6,7,8,9,2},
				{4,6,7,8,9},
				{1,4,6,2,8},
				{0,1,4,6,7}
		};
		
		System.out.println(isToepliz(m2));		
	}
	
	public static boolean isToepliz(int[][] m) {
		int col = m[0].length-1;
		int c1 = -1, r1 = -1;
		int val = -1;
		
		while (col >= 0) {
			c1 = col;
			r1 = 0;
			val = m[r1][c1];
			if (!checkDiagonal(val, m, r1,c1)) {
				return false;
			}
			
			col--;
		}

		int row = 1;
		while (row < m.length) {
			c1 = 0;
			r1 = row;
			val = m[r1][c1];
			if (!checkDiagonal(val, m, r1,c1)) {
				return false;
			}			
			row++;
		}

		return true;
	}

	private static boolean checkDiagonal(int val, int[][] m, int r1, int c1) {
		while(c1 < m[0].length && r1 < m.length) {
			if (m[r1][c1] != val) {
				return false;
			}
			r1++;
			c1++;
		}			
		return true;
	}
}
