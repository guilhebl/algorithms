package com.guilhebl.algo.math;

/**
 * 
 * http://www.geeksforgeeks.org/find-water-in-a-glass/
 *
 */
public class FindWaterGlass {

	// Driver program to test above function
	public static void main(String[] args)
	{
	    int i = 2, j = 2;
	    float X = 2.0f; // Total amount of water
	 
	    System.out.println("Amount of water in jth glass of ith row is: "
	    		+ findWater(i, j, X));
	}
	
	public static float findWater(int i, int j, float x) {
		
		if (j > i) {
			return -1.0f;
		}
		
		float cups[] = new float[i*(i+1)/2];
		int index = 0;
		cups[0] = x;
		
		for (int row = 1; row <= i && x > 0.0f; ++row) {
			for (int col = 1; col <= row; col++, index++) {
				x = cups[index];
				
				cups[index] = x >= 1.0f ? 1.0f : x;
				
				x = x >= 1.0f ? x - 1.0f : 0.0f;
				
				if (row + index < cups.length) {
					cups[row + index] += x/2;	
				}
				if (row + index + 1 < cups.length) {
					cups[row + index + 1] += x/2;
				}				
			}
		}				
		return cups[i*(i-1)/2 + j - 1];
	}
}
