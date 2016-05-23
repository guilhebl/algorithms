package com.guilhebl.algo.arrays;

public class TicTacToeWinDetect {
	
	public static void main(String[] args) {
		testSolution();
	}

	public static void testSolution() {

		// test win row
		Character[][] board = new Character[][] {
			{'X', 'X', 'X'},
			{'O', 'X', 'O'},
			{'X', 'O', 'O'}
		};
		System.out.println(detectWin(board));
		
		// test win col
		board = new Character[][] {
			{'X', 'O', 'X'},
			{'X', 'X', 'O'},
			{'X', 'O', 'O'}
		};
		System.out.println(detectWin(board));
		
		// test win diag
		board = new Character[][] {
			{'X', 'O', 'O'},
			{'O', 'X', 'O'},
			{'X', 'O', 'X'}
		};
		
		// test no win
		board = new Character[][] {
			{'X', 'O', 'X'},
			{'O', 'O', 'X'},
			{'X', 'X', 'O'}
		};

		System.out.println(detectWin(board));
		
		// test win col O
		board = new Character[][] {
			{'X', 'O', 'O'},
			{'O', 'X', 'O'},
			{'X', 'O', 'O'}
		};
		System.out.println(detectWin(board));
	}
	
	public static boolean detectWin(Character[][] board) {	
		return (testToken(board, 'X') || testToken(board, 'O'));
	}
	
	public static boolean testToken(Character[][] board, Character token) {
		// check rows
		int seq = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].equals(token)) {
					seq++;
				} 				
			}		
			if (seq == 3) {
				return true;
			}
			seq = 0;
		}

		seq = 0;
		// check cols
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i].equals(token)) {
					seq++;
				}
			}			
			if (seq == 3) {
				return true;
			}
			seq = 0;			
		}

		// check diagonals
		if ((board[0][0].equals(token) && 
				board[1][1].equals(token) &&
				board[2][2].equals(token)) ||
				(board[2][0].equals(token) && 
				board[1][1].equals(token) &&
				board[0][2].equals(token))) {
			return true;
		}
		return false;
	}
}
