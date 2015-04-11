package com.guilhebl.algo;

/**
Find the minimum cost to reach destination using a train
There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost for all pair of stations (i, j) is given where j is greater than i. Find the minimum cost to reach the destination.

Consider the following example:

Input: 
cost[N][N] = { {0, 15, 80, 90},
              {INF, 0, 40, 50},
              {INF, INF, 0, 70},
              {INF, INF, INF, 0}
             };
There are 4 stations and cost[i][j] indicates cost to reach j 
from i. The entries where j < i are meaningless.

Output:
The minimum cost is 65
The minimum cost can be obtained by first going to station 1 
from 0. Then from station 1 to station 3.

 * @author root
 *
 */
public class MinCostTravelStations {

	public static void solveMinCostTravelStations() {
		int[][] a = { { 0, 15, 80, 90 }, { -1, 0, 40, 50 }, { -1, -1, 0, 70 },
				{ -1, -1, -1, 0 } };
		System.out.println(getMinCostMatrixOriginDest(a));
	}

	public static int getMinCostMatrixOriginDest(int m[][]) {

		int n = m.length;
		int dist[] = new int[n];

		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		dist[1] = m[0][1];

		for (int i = 2; i < n; i++) {
			for (int j = 0; j < i; j++) {
				dist[i] = Math.min(dist[i], dist[j] + m[j][i]);
			}
		}

		return dist[n - 1];
	}

}
