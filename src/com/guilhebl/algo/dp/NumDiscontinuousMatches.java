package com.guilhebl.algo.dp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
Question: Given two strings, find number of discontinuous matches.
Example: “cat”, “catapult”
Output: 3  -- “CATapult”, “CatApulT”, “CAtapulT”
 * @author root
 *
 */
class NumDiscontinuousMatches {

	public static void main(String[] args) {
		System.out.println(findNumDiscontinuousMatches("catapult", "cat"));
	}

	public static int findNumDiscontinuousMatches(String s, String t) {
		if (s == null || s.equals("") || t == null || t.equals("")){
		 return 0;
		}

		int sl = s.length();
		int tl = t.length();

		char[] charsS = s.toCharArray();
		char[] charsT = t.toCharArray();

		int dp[][] = new int[tl+1][sl+1];

		for (int i = 0; i < sl; i++) {
		 dp[0][i] = 1;
		}

		for (int i = 1; i <= tl; i++) {
		 for (int j = 1; j <= sl; j++) {
		   if (charsT[i-1] == charsS[j-1]) {
		      dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
		   } else {
		      dp[i][j] = dp[i][j-1];
		   }
		 }
		}

		return dp[tl][sl];
	}
	
    private static void allSubsets(int num, String out) {
        if(num == 0){
            System.out.println(out);
        } else if (num > 0){
            for(int i = 1; i <= num; i++)
                allSubsets(num - i, out + " " + Integer.toString(i));
        }
    }	

    private static void printAllSubsetsSumUpToN(int[] a, int i, int sum, String out) {
        if(sum == 0){
            System.out.println(out);
        } else if (sum > 0){
            for(int j = i; j < a.length; j++)
            	printAllSubsetsSumUpToN(a, j + 1, sum -a[j], out + " " + a[j]);
        }
    }	


	public static int findNumWaysSumChange(int coins[], int sum) {		
		int n = coins.length;				
		int s[][] = new int[sum+1][n];
		for (int i = 0; i < n; i++) {
			s[0][i] = 1;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				
				int maxI = (i - coins[j] >= 0) ? s[i - coins[j]][j] : 0;
				int maxE = (j >= 1) ? s[i][j-1] : 0;
				
				s[i][j] = maxI + maxE;										
			}			
		}
						
		return s[sum][n-1];
	}

	public static long findNumWaysSumChangeLong(int coins[], int sum) {		
		int n = coins.length;				
		long s[][] = new long[sum+1][n];
		for (int i = 0; i < n; i++) {
			s[0][i] = 1;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				
				long maxI = (i - coins[j] >= 0) ? s[i - coins[j]][j] : 0;
				long maxE = (j >= 1) ? s[i][j-1] : 0;
				
				s[i][j] = maxI + maxE;										
			}			
		}
						
		return s[sum][n-1];
	}

	
	public static boolean isSubsetSum(int[] a, int k) {
		boolean m[][] = new boolean[k + 1][a.length + 1];
		
		for (int i = 0; i <= a.length; i++) {
			m[0][i] = true;
		}
		for (int i = 1; i <= k; i++) {
			m[i][0] = false;
		}		
		
		//Set<Integer> intList = new HashSet<Integer>();
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= a.length; j++) {
				m[i][j] = m[i][j-1];
				if (a[j-1] <= i) {
					if (!m[i][j] && m[i - a[j-1]][j-1]) {
						m[i][j] = m[i - a[j-1]][j-1];
						//intList.add(a[j-1]);
					}
				}
			}			
		}

		//System.out.println(intList);
		//printMatrix(m);
		
		return m[k][a.length];
	}
	
	// 3 ,2, 4, 1
	public static int findNumUnorderedPairsArray(int a[]) {
		
		int n = a.length;
		int s[] = new int[n];
		s[0] = 0;
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					s[i] = s[i] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < s.length; i++) {
			max = Math.max(max, s[i]);
		}
		
		return max;
	}
	
	static List<Integer> findSubset(int[] numbers, int M) {
		int N = numbers.length;
		HashMap<Integer, LinkedList<Integer>> subsets = new HashMap<Integer, LinkedList<Integer>>();
		subsets.put(0, new LinkedList<Integer>());
		for(int n : numbers) {
			HashSet<Integer> keys = new HashSet<Integer>(subsets.keySet());
			for(int i : keys) {
				int sum = (i+n) % M;
				if(sum == 0) {
					subsets.get(i).add(n);
					return subsets.get(i);
				}
				if(subsets.containsKey(sum))
					continue;
				LinkedList<Integer> list = (LinkedList<Integer>)subsets.get(i).clone();
				list.add(n);
				subsets.put(sum, list);
			}
		}
		return null;
	}
	

	public static void printMatrix(boolean[][] m) {
		for (int i =0; i < m.length; i++) {
			  for (int j =0; j < m[0].length; j++) {
			    System.out.print(m[i][j] + " ");
			 }
			    System.out.println();
			}
	}
	
}