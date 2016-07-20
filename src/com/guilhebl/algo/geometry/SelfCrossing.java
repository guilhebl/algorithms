package com.guilhebl.algo.geometry;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/self-crossing/
 *
 */
public class SelfCrossing {

	 public static void main(String[] args) {
		int[] a = {1,1,2,1,1};
	
		System.out.println(isSelfCrossing(a));
	 }
	
	
	 public static boolean isSelfCrossing(int[] x) {
		 if (x == null || x.length < 4) {
			 return false;
		 }
	        
		 int direction = 1; // start North
		 int moves = 0;
		 int cX = 0;
		 int cY = 0;
		 Set<Point2D> pointSets = new HashSet<>();
		 pointSets.add(new Point2D(0,0)); // origin
		 Point2D p = null;

		 for (int i = 0; i < x.length; i++) {
			moves = x[i];
			while (moves > 0) {
				if (direction == 1) {
					cY++;
				}
				else if (direction == 2) {
					cX--;
				}		
				else if (direction == 3) {
					cY--;
				}
				else if (direction == 4) {
					cX++;
				}	
				
				p = new Point2D(cX, cY);
				if (pointSets.contains(p)) {
					return true;
				} else {
					pointSets.add(p);
				}				
				moves--;
			}
			if (direction == 4) {
				direction = 0;
			}	
			direction++;
		 }	 	   
		 return false;
	 }
}

class Point2D {
	int x;
	int y;
	public Point2D(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}