package com.guilhebl.algo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Find shortest K distant points (x,y) from Origin (0,0) in a 2d map.
 *  
 * @author root
 *
 */
public class KShortestDistancePointsFromOrigin {

	public static void main(String args[]) {

		Point p1 = new Point(1, 3, findDistanceOfPoints(1, 3, 0, 0));
		Point p2 = new Point(3, 4, findDistanceOfPoints(3, 4, 0, 0));
		Point p3 = new Point(-1, 5, findDistanceOfPoints(-1, 5, 0, 0));
		Point p4 = new Point(-2, 2, findDistanceOfPoints(-2, 2, 0, 0));
		Point p5 = new Point(2, 3, findDistanceOfPoints(2, 3, 0, 0));

		List<Point> ptList = new ArrayList<Point>();

		ptList.add(p1);
		ptList.add(p2);
		ptList.add(p3);
		ptList.add(p4);
		ptList.add(p5);

		int k = 3;
		printClosestPointsToOrigin(ptList, k);
	}

	public static void printClosestPointsToOrigin(List<Point> ptList, int k) {
		ptList.sort(new PointDistanceFromOriginComparator());
		int i = 0;

		while (i < ptList.size() && i < k) {
			Point p = ptList.get(i);
			System.out.println("X: " + p.x + " Y: " + p.y);
			i++;
		}
		
	}

	public static int findDistanceOfPoints(int x1, int x2, int y1, int y2) {
		Double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		return dist.intValue();
	}

}

class Point {

	int x, y;
	int distanceFromOrigin;

	public Point(int x, int y, int distO) {
		this.x = x;
		this.y = y;
		this.distanceFromOrigin = distO;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", distanceFromOrigin="
				+ distanceFromOrigin + "]";
	}	
}

class PointDistanceFromOriginComparator implements Comparator<Point> {

	public int compare(Point p1, Point p2) {
		if (p1.distanceFromOrigin < p2.distanceFromOrigin) {
			return -1;
		} else if (p1.distanceFromOrigin > p2.distanceFromOrigin) {
			return 1;
		}
		return 0;
	}

}