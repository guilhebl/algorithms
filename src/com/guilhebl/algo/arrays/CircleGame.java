package com.guilhebl.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1735
 *  
 * @author root
 *
 */
public class CircleGame {
	
	public static void main(String[] args) {
		solveCardsLeft();
	}
	
	public static void solveCardsLeft() {
		System.out.println(cardsLeft("KKKKKKKKKK"));
		System.out.println(cardsLeft("KKKKKAQT23"));
		System.out.println(cardsLeft("KKKKATQ23J"));
		System.out.println(cardsLeft("AT68482AK6875QJ5K9573Q"));
		System.out.println(cardsLeft("AQK262362TKKAQ6262437892KTTJA332"));		
	}
	
	public static int cardsLeft(String deck) {
		char[] c = deck.toCharArray();				
		List<Integer> vals = new ArrayList<>(deck.length());
		for (int i = 0; i < c.length; i++) {
			vals.add(getCardValue(c[i]));
		}		
		int oldSize = vals.size();
		boolean hasMore = true;
		
		while(hasMore) {						
			vals = cycleGame(vals);
			if (oldSize == vals.size()) {
				hasMore = false;
			} else {
				oldSize = vals.size();
			}
		}						
		return vals.size();
	}
	
	private static int[] getIntArrayFromList(List<Integer> vals) {
		int[] a = new int[vals.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = vals.get(i);
		}
		return a;
	}

	private static List<Integer> getListFromArray(int[] a, List<Integer> indexes) {
		List<Integer> vals = new ArrayList<>(a.length);
		for (int i = 0; i < a.length; i++) {
			if(!indexes.contains(i)) {
				vals.add(a[i]);
			}
		}
		return vals;
	}

	private static List<Integer> cycleGame(List<Integer> vals) {				
		int[] a = getIntArrayFromList(vals);
		List<Integer> indexesForRemoval = new ArrayList<>();
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] == 13) {
				indexesForRemoval.add(i);
			}			
		}
		vals = getListFromArray(a, indexesForRemoval);
		a = getIntArrayFromList(vals);
		indexesForRemoval = new ArrayList<>();
		
		for (int i = 1; i < a.length; i++) {
			if(a[i] + a[i-1] == 13) {
				indexesForRemoval.add(i);
				indexesForRemoval.add(i-1);
			}			
		}

		vals = getListFromArray(a, indexesForRemoval);
		a = getIntArrayFromList(vals);
		indexesForRemoval = new ArrayList<>();
		
		if (a.length >= 2) {
			if(a[0] + a[a.length-1] == 13) {
				indexesForRemoval.add(0);
				indexesForRemoval.add(a.length-1);
			}						
		}
		vals = getListFromArray(a, indexesForRemoval);			
		return vals;
	}

	private static Integer getCardValue(char c) {				
		switch(c) {		
			case 'A' : return 1;
			case '2' : return 2;
			case '3' : return 3;
			case '4' : return 4;
			case '5' : return 5;
			case '6' : return 6;
			case '7' : return 7;
			case '8' : return 8;
			case '9' : return 9;
			case 'T' : return 10;
			case 'J' : return 11;
			case 'Q' : return 12;
			case 'K' : return 13;
		}
		
		return null;
	}
}
