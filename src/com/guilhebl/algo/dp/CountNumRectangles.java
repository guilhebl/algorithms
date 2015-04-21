package com.guilhebl.algo.dp;

public class CountNumRectangles {

	public static void main(String[] args) {
		System.out.println(countRectangles(3, 3));
	}
	
	public static long countRectangles(int width, int height) {
		
  	    long widthL = (long) width;
		long heightL = (long) height;		

		//(width^2 + width) * (length^2 + length) / 4 - formula
		long totalCountWithSquares = ( ((widthL * widthL) + widthL) * ((heightL * heightL) + heightL) / 4 );
		long totalWithoutSquares = totalCountWithSquares;
		
		for(int i = 1; i <= Math.min(width, height); i++) {
			totalWithoutSquares -= countSquaresInRectangle(i, width, height);
		}
		return totalWithoutSquares;
	}
	
	private static long countSquaresInRectangle(int s, int width, int height) {
		long count = 0;

		for (int x = 0; (x + s) <= width; x++) {
			for (int y = 0; (y + s) <= height; y++) {
				count++;
			}
		}

		return count;
	}	
}
