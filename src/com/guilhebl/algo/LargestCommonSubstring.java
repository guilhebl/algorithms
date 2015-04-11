package com.guilhebl.algo;
import java.util.Stack;


/**
 * Get largest common substring of 2 given strings
 * @author root
 *
 */
public class LargestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(findLargestCommonSubstring("ABCTESAURUSXYZ", "RRTTESAURUSSAZ"));
	}
	
	public static int findLargestCommonSubstring(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return 0;
		}		
		int maxLength = 0;
		
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
				
		Stack<Duplet> longestIndexes = new Stack<Duplet>();
		
		int[][] f = new int[s.length() + 1][t.length() + 1];
		
		for (int i = 0; i < sc.length; i++) {
			for (int j = 0; j < tc.length; j++) {
				if(sc[i] == tc[j]) {
					if (i == 0 || j == 0) {
						f[i][j] = 1;
					} else {
						f[i][j] = f[i-1][j-1] +1;
					}
					
					if (maxLength < f[i][j]) {
						maxLength = f[i][j];
						if (longestIndexes.isEmpty() || longestIndexes.peek().length < maxLength) {
							if (!longestIndexes.isEmpty()) {
								longestIndexes.clear();
							}
							longestIndexes.push(new Duplet(i, maxLength));
						} else if (longestIndexes.peek().length == maxLength) {
							longestIndexes.push(new Duplet(i, maxLength));
						}																		
					} else if (maxLength == f[i][j]) {
						longestIndexes.push(new Duplet(i, maxLength));						
					}															
				}								
			}			
		}
					
		Duplet longestDuplet = longestIndexes.pop(); 
		int indexLongest = longestDuplet.index;
		int indexLength = longestDuplet.length;
		if(s.length() >= t.length()) {
			System.out.println(s.substring(indexLongest - indexLength + 1, indexLongest + 1));
		} else {
			System.out.println(t.substring(indexLongest - indexLength + 1, indexLongest + 1));	
		}				
		return maxLength; 
	}

}

class Duplet {				
	int index;
	int length;
	
	public Duplet() {
	}

	public Duplet(int index, int length) {
		super();
		this.index = index;
		this.length = length;
	}
	
	@Override
	public String toString() {		
		return index + " " + length;
	}
	
}
