package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		List<Set<Integer>> nodeEdges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nodeEdges.add(new HashSet<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int n1 = edges[i][0];
			int n2 = edges[i][1];
			nodeEdges.get(n1).add(n2);
			nodeEdges.get(n2).add(n1);
		}
		
		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < nodeEdges.size(); i++) {
			if (nodeEdges.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		
		int count = edges.length;
		while (count > 2 && !leaves.isEmpty()) {
			count -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (Integer leaf : leaves) {
				int node = nodeEdges.get(leaf).iterator().next();
				nodeEdges.get(node).remove(leaf);
				if (nodeEdges.get(node).size() == 1){
					newLeaves.add(node);
				}
			}
			leaves = newLeaves;
		}
		r = leaves;
		return r;
	}
}
