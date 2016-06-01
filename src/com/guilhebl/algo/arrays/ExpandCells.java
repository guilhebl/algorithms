package com.guilhebl.algo.arrays;

public class ExpandCells {
	
	public static void main(String[] args) {
		int[] x = {1};
		int[] y = {1};
		int[][] m = getLockerDistanceGrid(3, 5, x, y);
		printMatrix(m);
		
	}
	
	public static void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
  public static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        if (cityLength == 0 || cityWidth == 0 || lockerXCoordinates == null || lockerYCoordinates == null) {
            return null;
        }
        int undiscovered = Integer.MAX_VALUE;
        
        int[][] m = new int[cityWidth][cityLength];
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {            
                m[i][j] = undiscovered;                
            }            
        }
        
        for (int i = 0; i < lockerXCoordinates.length; i++) {
            m[lockerYCoordinates[i] - 1][lockerXCoordinates[i] - 1] = 0;
        }
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {            
                if (m[i][j] == 0) {
                    expandLocker(m, i, j);
                }
            }            
        }
        
        return m;
                                    
    }

  public static void expandLocker(int[][] m, int row, int col) {

	  if (row >= 0 && row < m.length && col >= 0 && col < m[0].length) {
			  expand(m, row - 1, col - 1, 2);
			  expand(m, row - 1, col, 1);
			  expand(m, row - 1, col + 1, 2);
			  expand(m, row, col + 1, 1);
			  expand(m, row + 1, col + 1, 2);
			  expand(m, row + 1, col, 1);
			  expand(m, row + 1, col - 1, 2);
			  expand(m, row, col - 1, 1);			  
	  }	  
	}

  public static void expand(int[][] m, int row, int col, int dist) {

	  if (row >= 0 && row < m.length && col >= 0 && col < m[0].length) {
		  if (m[row][col] > dist) {
			  m[row][col] = dist;
			  expand(m, row - 1, col - 1, dist + 2);
			  expand(m, row - 1, col, dist + 1);
			  expand(m, row - 1, col + 1, dist + 2);
			  expand(m, row, col + 1, dist + 1);
			  expand(m, row + 1, col + 1, dist + 2);
			  expand(m, row + 1, col, dist + 1);
			  expand(m, row + 1, col - 1, dist + 2);
			  expand(m, row, col - 1, dist + 1);			  
		  }
	  }	  
	}
  
public static void expand(int[][] m, int row, int col) {
    int i = row, j = col;
    int dist = 0;
    // up
    while(i - 1 >= 0 && m[i-1][j] > dist + 1) {
        m[i-1][j] = dist + 1;
        dist++;
        i--;
    }

    // up-right
    i = row;
    j = col;
    dist = 0;    
    while(i - 1 >= 0 && j + 1 < m[0].length && m[i-1][j + 1] > dist + 2) {
        m[i-1][j + 1] = dist + 2;
        dist += 2;
        i--;
        j++;
    }

    // right
    i = row;
    j = col;
    dist = 0;    
    while(j + 1 < m[0].length && m[i][j + 1] > dist + 1) {
        m[i][j + 1] = dist + 1;
        dist++;
        j++;
    }

    // down-right
    i = row;
    j = col;
    dist = 0;    
    while(i + 1 < m.length && j + 1 < m[0].length && m[i + 1][j + 1] > dist + 2) {
        m[i + 1][j + 1] = dist + 2;
        dist += 2;
        j++;
        i++;
    }

    // down
    i = row;
    j = col;
    dist = 0;    
    while(i + 1 < m.length && m[i + 1][j] > dist + 1) {
        m[i + 1][j] = dist + 1;
        dist++;
        i++;
    }

    // down-left
    i = row;
    j = col;
    dist = 0;    
    while(i + 1 < m.length && j - 1 >= 0 && m[i + 1][j - 1] > dist + 2) {
        m[i + 1][j - 1] = dist + 2;
        dist += 2;
        j--;
        i++;
    }

    // left
    i = row;
    j = col;
    dist = 0;    
    while(j - 1 >= 0 && m[i][j - 1] > dist + 1) {
        m[i][j - 1] = dist + 1;
        dist++;
        j--;
    }

    // up-left
    i = row;
    j = col;
    dist = 0;    
    while(i - 1 >= 0 && j - 1 >= 0 && m[i-1][j-1] > dist + 2) {
        m[i-1][j-1] = dist + 2;
        dist += 2;
        i--;
        j--;
    }

}

}
