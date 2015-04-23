package com.guilhebl.algo.dp;

/**
 * TopCoder problem count num rectangles.
 * 
 * Count num. of rectangles inside a WxH Matrix.
 * 
 * Rectangles are different than squares as their Width and Height are not equal. 
 * 
 * Formula to count rectangles in a NxM matrix:
 * 
 * //(width^2 + width) * (length^2 + length) / 4 - formula
 * 
 * @author root
 *
 */
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
