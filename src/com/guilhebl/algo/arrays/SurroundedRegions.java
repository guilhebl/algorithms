package com.guilhebl.algo.arrays;

/**
 * 
 * https://leetcode.com/problems/surrounded-regions/
 *
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();

		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		sr.solve(board);
		printMatrix(board);

		char[][] m = { { 'X', 'O', 'X', 'X' }, { 'O', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X' } };
		sr.solve(m);
		printMatrix(m);

	}

	private static void printMatrix(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		char t = 'Y'; // marker char
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				board[0][i] = t;
				mark(board, 0, i, t);
			}
			if (board[board.length - 1][i] == 'O') {
				board[board.length - 1][i] = t;
				mark(board, board.length - 1, i, t);
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = t;
				mark(board, i, 0, t);
			}
			if (board[i][board[0].length - 1] == 'O') {
				board[i][board[0].length - 1] = t;
				mark(board, i, board[0].length - 1, t);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void mark(char[][] board, int i, int j, char c) {
		// up
		if (i - 1 > 0 && board[i - 1][j] == 'O') {
			board[i - 1][j] = c;
			mark(board, i - 1, j, c);
		}
		// right
		if (j + 1 < board[0].length - 1 && board[i][j + 1] == 'O') {
			board[i][j + 1] = c;
			mark(board, i, j + 1, c);
		}
		// down
		if (i + 1 < board.length - 1 && board[i + 1][j] == 'O') {
			board[i + 1][j] = c;
			mark(board, i + 1, j, c);
		}
		// left
		if (j - 1 > 0 && board[i][j - 1] == 'O') {
			board[i][j - 1] = c;
			mark(board, i, j - 1, c);
		}
	}
}
