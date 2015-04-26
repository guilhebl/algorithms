package com.guilhebl.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=13700&rd=16318
 * 
 * "aaaba" is 8: 
 * there are four occurrences of the substring "a", 
 * two occurrences of "aa",
 * one occurrence of "aaa",
 * and one of "b".
 * 
 */
public class SquareScores {

	public static void main(String[] args) {
		solveSquareScores();
	}
	
	public static void solveSquareScores() {
		String s = "aaaba";
		System.out.println(getScore(s));
		
		String s1 = "zzzxxzz";
		System.out.println(getScore(s1));

		String s2 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(getScore(s2));

		String s21 = "p";
		System.out.println(getScore(s21));

		String s3 = "aaaaa";
		System.out.println(getScore(s3));

	}
	
	public static int getScore(String s) {	
		int maxScore = 0;
		int count = 0;
		char curr;
		char[] c = s.toCharArray();
		int j;
		String key = null;
		Map<String, Integer> charCount = new HashMap<String, Integer>();

		for (int i = 0; i < c.length; i++) {
			key = new Character(c[i]).toString() + i;
			count = 1;
			curr = c[i];
			j = i + 1;
			while(j < c.length && curr == c[j]) {
				count++;
				j++;
			}	
			i = j - 1;
			charCount.put(key, count);			
		}

		for(Map.Entry<String, Integer> e : charCount.entrySet()) {
			maxScore += getCountNumberOfPermutations(e.getValue());
		}
		
		return maxScore;		
	}

	private static int getCountNumberOfPermutations(Integer value) {
		if (value == 2) {
			return 3;
		}

		int i = value-1;
		int sum = value;
		
		while( i > 0 ) {
			sum *= i;
			i--;
		}				
		return sum;
	}
}
