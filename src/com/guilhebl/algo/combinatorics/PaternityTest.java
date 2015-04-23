package com.guilhebl.algo.combinatorics;

/**
 * 
 * http://community.topcoder.com/stat?c=problem_statement&pm=1669
 *
 */
public class PaternityTest {
	
	public static void main(String[] args) {
	
		String c = "ABCD";
		String m = "AXCY";
		String[] p = {"SBTD", "QRCD"};
		printArray(possibleFathers(c,m,p));
		System.out.println();

		String c1 = "ABCD";
		String m1 = "ABCX";
		String[] p1 = { "ABCY", "ASTD", "QBCD" };
		printArray(possibleFathers(c1,m1,p1));
		System.out.println();

		String c2 = "ABABAB";
		String m2 = "ABABAB";
		String[] p2 = { "ABABAB", "ABABCC", "ABCCDD", "CCDDEE" };
		printArray(possibleFathers(c2,m2,p2));
		System.out.println();
		

		String c3 = "YZGLSYQT";
		String m3 = "YUQRWYQT";
		String[] p3 = {"YZQLDPWT", "BZELSWQM", "OZGPSFKT", "GZTKFYQT", "WQJLSMQT"};				
		printArray(possibleFathers(c3,m3,p3));
		System.out.println();
		
		String c4 = "WXETPYCHUWSQEMKKYNVP";
		String m4 = "AXQTUQVAUOSQEEKCYNVP";
		String[] p4 = 		{ "WNELPYCHXWXPCMNKDDXD", "WFEEPYCHFWDNPMKKALIW", "WSEFPYCHEWEFGMPKIQCK", "WAEXPYCHAWEQXMSKYARN", "WKEXPYCHYWLLFMGKKFBB" };
		printArray(possibleFathers(c4,m4,p4));		
		System.out.println();
		
	}
	
	private static void printArray(int[] possibleFathers) {
		for (int i = 0; i < possibleFathers.length; i++) {
			System.out.print(possibleFathers[i] + " ");
		}		
	}

	public static int[] possibleFathers(String child, String mother, String[] men) {
		if (child == null || mother == null || men == null) {
			return null;
		}
		
		boolean[] ruledOut = new boolean[men.length];
		char[] c = child.toCharArray();		
		char[] m = mother.toCharArray();
		char[] p = null;
		int ruledOutCount = 0;

		for (int j = 0; j < men.length; j++) {
			p = men[j].toCharArray();
			int charsInCommon = 0;
			for (int j2 = 0; j2 < p.length; j2++) {
				if (p[j2] == c[j2]) {
					charsInCommon++;
				}				
			}
			if (charsInCommon >= c.length/2) {
				ruledOut[j] = false;
			} else {
				ruledOut[j] = true;
				ruledOutCount++;
			}
		}								

		for (int i = 0; i < c.length; i++) {
			if(c[i] != m[i]) {
				for (int j = 0; j < men.length; j++) {
					p = men[j].toCharArray();					
					if (!ruledOut[j] && p[i] != c[i]) {
						ruledOut[j] = true;
						ruledOutCount++;
					}
				}								
			}
		}

		int a[] = new int[men.length - ruledOutCount];
		int i = 0;
		
		for (int j = 0; j < men.length; j++) {							
			if (!ruledOut[j]) {
				a[i] = j;
				i++;
			}
		}														
		return a;
	}
}
