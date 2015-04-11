package com.guilhebl.algo;

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
		solveMultiPerms();
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

}
