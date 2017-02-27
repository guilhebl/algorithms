package com.guilhebl.algo.arrays;

/**
 * Calculate win probability in Bomb sweeper game, 
 * 
 * input MxN board such as:

.....
.....
..B..
.....
.....
 * 
 * or
 * 
BBBBB
B...B
B...B
B...B
BBBBB
 * 
 * output: percentage of chance to win game.
 * 
 * rules: the map starts totally undiscovered, user needs to select a 
 * starting cell, if a bomb is in that cell, he loses.
 * If an empty square is in that cell, check if neighbors are bomb, if no neighbor cell is neighbor of a bomb
 * win, so formula is
 * 
 * percentage of chances: 
 * 
 * (count of empty cells w/no neighbor bombs)/(count of empty cells w/no neighbor bombs + count bombs) * 100 
 *  
 * 
 * @author root
 *
 */
public class BombSweeperProbabilityWin {

	public static void main(String[] args) {
		solveBombSweepProbWin();
	}
	
	public static void solveBombSweepProbWin() {
		String[] m = { ".....", ".....", "..B..", ".....", "....." };
		
		String[] m1 = {"BBBBB",
				 "B...B",
				 "B...B",
				 "B...B",
				 "BBBBB"};

		System.out.println(winPercentage(m));
		System.out.println(winPercentage(m1));
	}

	public static double winPercentage(String[] board) {
		if (board == null || board.length == 0) {
			return 0.0D;
		}

		double percWin = 0.0D;
		int countBomb = 0, countEmptySpaces = 0;
		char[][] boardMatrix = new char[board.length][board[0].length()];
		for (int i = 0; i < board.length; i++) {
			char[] charsI = board[i].toCharArray();
			for (int j = 0; j < charsI.length; j++) {
				boardMatrix[i][j] = charsI[j];
			}
		}

		printMatrix(boardMatrix);
		int cellType = -1;
		for (int i = 0; i < boardMatrix.length; i++) {
			for (int j = 0; j < boardMatrix[0].length; j++) {
				cellType = findCellType(boardMatrix, i, j);
				if (cellType == 1) {
					countEmptySpaces++;
				} else if (cellType == 3) {
					countBomb++;
				} else {
					return -1; // error
				}
			}
		}

		percWin = (new Double(countEmptySpaces) / new Double(countEmptySpaces + countBomb)) * 100;
		return percWin;
	}

	public static void printMatrix(char[][] m) {
		for (int i = 0; i < m.length; i++) {
		  for (int j = 0; j < m[0].length; j++) {			
		    System.out.print(m[i][j]);
		  }	
		  System.out.println();
		}
	}
	/*
	 * cellType = 1: empty with no bombs surrounding cellType = 2: empty with
	 * bombs surrounding cellType = 3: bomb
	 */
	public static int findCellType(char[][] m, int i, int j) {
		if (m[i][j] == 'B') {
			return 3;
		} else if (m[i][j] == '.') {

			// do a 360 check starting from left
			if (j > 0) {
				if (m[i][j - 1] == 'B') {
					return 2;
				}
			} 
			if (j > 0 && i > 0) {
				if (m[i - 1][j - 1] == 'B') {
					return 2;
				}
			} 
			if (i > 0) {
				if (m[i - 1][j] == 'B') {
					return 2;
				}
			} 
			if (i > 0 && j < m[i].length - 1) {
				if (m[i - 1][j + 1] == 'B') {
					return 2;
				}
			} 
			if (j < m[0].length - 1) {
				if (m[i][j + 1] == 'B') {
					return 2;
				}
			} 
			if (i < m.length - 1 && j < m[i].length - 1) {
				if (m[i + 1][j + 1] == 'B') {
					return 2;
				}
			} 
			if (i < m.length - 1) {
				if (m[i + 1][j] == 'B') {
					return 2;
				}
			} 
			if (i < m.length -1 && j > 0) {
				if (m[i + 1][j - 1] == 'B') {
					return 2;
				}
			}

			return 1;
		}

		return -1;
	}

}
