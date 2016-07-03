package com.guilhebl.algo.geometry;

/**
 * 
 * https://leetcode.com/problems/rectangle-area/
 *
 */
public class AreaIntersectionTwoRectangles {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	      PointRec pA = new PointRec(A,B,C,D);
	      PointRec pB = new PointRec(E,F,G,H);
	      int areaA = (pA.x2 - pA.x1) * (pA.y2 - pA.y1);
	      int areaB = (pB.x2 - pB.x1) * (pB.y2 - pB.y1);
	      int areaU = areaA + areaB;
	      if(pA.x2 <= pB.x1 || pB.x2 <= pA.x1 || pB.y2 <= pA.y1 || pA.y2 <= pB.y1) 
	    	  return areaU;
	
	      int ix =  Math.min(pA.x2, pB.x2) - Math.max(pA.x1, pB.x1);
	      int iy =  Math.min(pA.y2, pB.y2) - Math.max(pA.y1, pB.y1);
	      int iA = ix * iy;
	        
	      return (areaU) - iA;	      
	    }
}

class PointRec {
	int x1;
	int y1;
	int x2;
	int y2;
	public PointRec(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}	
}