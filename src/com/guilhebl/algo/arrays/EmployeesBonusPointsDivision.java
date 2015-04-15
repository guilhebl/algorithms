package com.guilhebl.algo.arrays;

/**
 * 
 * You have an array consisting of points each employee has, according to the total points, distribute bonus to each employee according to percentage distribution
 * for example:
 * 
{1,2,3,4,5}
The total points in the point pool is 1+2+3+4+5 = 15.

you then distribute the bonus to each employee in array according to each of employee's distribution percentage.

emplyee 1: 1/15 = 0.06 = 6% of total bonus of 100%;

for the remaining percentage of 100 distribute it to the top N employees with highest scores:

Input: {1,2,3,4,5}
Returns: { 6,  13,  20,  27,  34 }

 * @author root
 *
 */
public class EmployeesBonusPointsDivision {


	public static void main(String[] args) {
		solveGetDivision();
	}
	
	public static void solveGetDivision() {
		int a[] = {1,2,3,4,5};
		printArray(getDivision(a));			
		
		System.out.println();
		
		int[] b = {5,5,5,5,5,5};
		printArray(getDivision(b));
	}
	
	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static int[] getDivision(int[] points) {
		if (points == null || points.length == 0) {
			return null;
		}
		
		int[] a = new int[points.length];
		int sum = 0;
		int total = 100;
		
		for(int i = 0; i < points.length; i++) {
			sum += points[i];
		}
		
		for(int i = 0; i < points.length; i++) {
			a[i] = new Double((new Double(points[i]) / new Double(sum)) * 100).intValue();
			total = total - a[i];
		}
		
		int rem = total;
		int maxPoints = -1, indexMax = -1;
		boolean bonusGranted[] = new boolean[points.length];
		boolean stillMore = true;
		
		while(rem > 0 && stillMore) {
			for(int i = 0; i < points.length; i++) {
				if (!bonusGranted[i] && maxPoints < points[i]) {
					maxPoints = points[i];
					indexMax = i;
				}								
			}
			if (indexMax != -1) {
				a[indexMax] = a[indexMax] + 1;
				bonusGranted[indexMax] = true;
				rem--;
			} else {
				stillMore = false;
			}			
			maxPoints = -1;
		}
		return a;
	}
	
	
}
