package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 */
public class MinHeightTrees {
	
	public static void main(String[] args) {
		int[][] a = {{1,0},{1,2},{1,3}};
		printList(findMinHeightTrees(4, a));
		
		int[][] a2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		printList(findMinHeightTrees(6, a2));

	}
	
	private static void printList(List<Integer> findMinHeightTrees) {
		for (Integer integer : findMinHeightTrees) {
			System.out.print(integer + ",");
		}
		System.out.println();
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> r = new ArrayList<>();
		if (edges.length == 0) {
			r.add(0);
			return r;
		}
		if (edges.length == 1) {
			r.add(edges[0][0]);
			r.add(edges[0][1]);
			return r;
		}
		
		int[] nodeEdgeCount = new int[n];
		for (int i = 0; i < edges.length; i++) {
			nodeEdgeCount[edges[i][0]] = nodeEdgeCount[edges[i][0]] + 1;
			nodeEdgeCount[edges[i][1]] = nodeEdgeCount[edges[i][1]] + 1;
		}
		int max1 = -1;
		int max2 = -1;
		int used1 = -1;
		int used2 = -1;
		int edgeCount = 0;
		for (int i = 0; i < nodeEdgeCount.length; i++) {
			edgeCount = nodeEdgeCount[i];
			if (edgeCount > 1 && edgeCount > max1 && used1 != i && used2 != i) {
				max1 = nodeEdgeCount[i];
				used1 = i;
			}
			if (edgeCount > 1 && edgeCount > max2 && used1 != i && used2 != i) {
				max2 = nodeEdgeCount[i];
				used2 = i;
			}			
		}

		if (used1 != -1) {
			r.add(used1);	
		}
		if (used2 != -1) {
			r.add(used2);
		}

		return r;
	}
}
