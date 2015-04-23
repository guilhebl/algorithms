package com.guilhebl.algo.arrays;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=1648
 *
 */
public class MaxWaitTimeBigBurger {

	public static void main(String[] args) {

		int a[] = {3,3,9};
		int s[] = {2,15,14};
		
		System.out.println(maxWait(a,s));
	}	
	
	/**
	 * @param arrival
	 * @param service
	 * @return
	 */
	public static int maxWait(int[] arrival, int[] service) {
		int maxWait = 0;
		int wt[] = new int[arrival.length];
		int ft[] = new int[arrival.length];
		
		wt[0] = 0;
		ft[0] = arrival[0] + service[0];
		
		for (int i = 1; i < arrival.length; i++) {
			wt[i] = ft[i-1] - arrival[i];
			ft[i] = arrival[i] + wt[i] + service[i];
			maxWait = Math.max(maxWait, wt[i]);
		}
		
		return maxWait;
	}
	

	
	
}
