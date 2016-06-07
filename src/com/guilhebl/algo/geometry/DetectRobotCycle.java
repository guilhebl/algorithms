package com.guilhebl.algo.geometry;

/**
 * https://careercup.com/question?id=5653668599693312
 *
 */
public class DetectRobotCycle {
		
	public static void main(String[] args) {
		int m[] = {10, 180, 10};
		System.out.println(isWallPossible(m));

		int m1[] = {10, 45, 10, -45, 10, 45};
		System.out.println(isWallPossible(m1));
		
		int m2[] = {10, 45, 10, -45, 10, 45, 10, -45};
		System.out.println(isWallPossible(m2));		
	}
	
	public static boolean isWallPossible(int[] moves) {		
		int treshold = 1000; // put a large enough treshold to test sample repeatedly until cycle found
		int i = 0;
		Position p = new Position(0, 0, MoveDirection.N); // start north
		boolean rotate = false;

		while (i < treshold) {
			rotate = false;
			for (int j = 0; j < moves.length; j++) {
				if (rotate) {
					p.addAngle(moves[j]);
				} else {
					p.steps += moves[j];					
				}
				rotate = !rotate;
			}
			if (p.cycled) {
			   return true;	
			}
			
			i++;
		}
		
		return false;
	}

}

class Position {
	int steps;
	int angle;
	MoveDirection d;
	boolean cycled;
	public Position(int x, int angle, MoveDirection d) {
		super();
		this.steps = x;
		this.angle = angle;
		this.d = d;
		this.cycled = false; 
	}		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (!d.equals(other.d))
			return false;
		if (angle != other.angle)
			return false;
		return true;
	}

	public void addAngle(int a) {
		angle += a;
		if (angle >= 720) {
			angle = angle % 720;
			cycled = true;
		}
		if(angle >= 0 && angle < 180) {
			d = MoveDirection.N;
		}
		else if(angle >= 180 && angle < 360) {
			d = MoveDirection.E;
		}
		else if(angle >= 360 && angle < 540) {
			d = MoveDirection.E;
		}
		else if(angle >= 540 && angle < 720) {
			d = MoveDirection.E;
		} 
	}
}

enum MoveDirection {
	N,E,S,W;
}