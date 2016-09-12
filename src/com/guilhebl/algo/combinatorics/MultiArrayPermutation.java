package com.guilhebl.algo.combinatorics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Print all permutations of a String[][] matrix:
 * 
 *  example: {{ "quick", "slow" },	{ "brown", "gray" }, { "fox", "dog" }, { "zen", "rex" }}
 *  
 *  output:
 *  
quick brown fox zen 
slow brown fox zen 
quick gray fox zen 
slow gray fox zen 
quick brown dog zen 
slow brown dog zen 
quick gray dog zen 
slow gray dog zen 
quick brown fox rex 
slow brown fox rex 
quick gray fox rex 
slow gray fox rex 
quick brown dog rex 
slow brown dog rex 
quick gray dog rex 
slow gray dog rex 
 *
 */
public class MultiArrayPermutation {

	public static void main(String[] args) {
		solveMultiPerms2();
	}
	
	public static void solveMultiPerms() {
		String[][] sets = new String[][] { { "quick", "slow" },
				{ "brown", "gray" }, { "fox", "dog" }, { "zen", "rex" } };
		int[] state = new int[sets.length];
		int p = 0;
		boolean stillHasMore = true;
		
		while (stillHasMore) {
			for (int i = 0; i < state.length; i++) {
				System.out.print(sets[i][state[i]] + " ");
			}
			System.out.println();
			state[p]++;
			while (stillHasMore && state[p] == sets[p].length) {
				state[p] = 0;
				p++;
				if (p == sets.length) {
					stillHasMore = false;
				} else {
					state[p]++;	
				}									
			}
			p = 0;
		}
	}

	public static void solveMultiPerms2() {
		String[][] sets = new String[][] { 
				{ "quick", "slow" },
				{ "brown", "red" }, 
				{ "fox", "dog" } 
				};
					
		List<List<String>> r = new ArrayList<List<String>>();
		backtrack(r, sets, new LinkedList<String>(), 0);
		
		printLists(r);
	}

	private static void printLists(List<List<String>> r) {
		for (List<String> list : r) {
			for (String string : list) {
				System.out.print(string + " ");
			}
			System.out.println();
		}		
	}

	private static void backtrack(List<List<String>> strs, String[][] sets, LinkedList<String> list, int start) {
		if (start == sets.length) {
			strs.add(new ArrayList<>(list));
		} else if (start < sets.length) {
			for (int i = 0; i < sets[start].length; i++) {
				list.addLast(sets[start][i]);				
				backtrack(strs, sets, list, start + 1);
				list.removeLast();								
			}						
		}		
	}
}
