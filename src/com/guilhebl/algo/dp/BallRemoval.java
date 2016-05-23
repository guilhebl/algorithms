package com.guilhebl.algo.dp;

import java.util.Arrays;

public class BallRemoval {

	public static void main(String[] args) {
		solveBallRemoval();
	}
	
	public static void solveBallRemoval() {
		System.out.println(canLeave("<<>"));
		System.out.println(canLeave(">>><<"));
		System.out.println(canLeave("<<><<"));
		System.out.println(canLeave("<><<><>"));
		System.out.println(canLeave(">>><<<>>>>><<<>"));		
	}
	
	public static String canLeave(String label) {
		if (label == null || label.length() < 3 || label.length() % 2 == 0) {
			return null;
		}
		
		int l = 1;
		int r = label.length()-2;		
		boolean[] cl = new boolean[label.length()];
		Arrays.fill(cl, true);		
		//StringBuilder sb = new StringBuilder(label);
		char[] c = label.toCharArray();
			
		canLeave(l, r, c, cl);
		
		String result = getOutputStr(cl);
		return result;
	}
	public static void canLeave(int l, int r, char[] c, boolean[] cl) {
		if (l > r) {
			return;
		} else if (l == r && l < c.length-1) {			
			if (c[l] == '<') {							
				cl[l] = false;
				cl[l-1] = false;
			} else if (c[l] == '>') {
				cl[l] = false;
				cl[l+1] = false;
			}			
		} else if (l < r) {						
			canLeave(l + 1, r, c, cl);			
			canLeave(l, r - 1, c, cl);
		}
	}

	private static String getOutputStr(boolean[] cl) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cl.length; i++) {
			if (cl[i]) {
				sb.append('o');
			} else {
				sb.append('.');
			}
		}		
		return sb.toString();
	}
}
