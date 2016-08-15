package com.guilhebl.algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://careercup.com/question?id=5695046734053376
 * @author root
 *
 */
public class MaxCityTraffic {
	
	public static void main(String[] args) {
		int[][] adj = {
		{1,5},
		{2,5},
		{3,5},
		{4,5}
		};

		int[][] adj2 = {
		{1,5},		
		{3,5},
		{4,5},
		{2,5},
		{2,7},
		{2,15}
		};

		MaxCityTraffic mc = new MaxCityTraffic();
		mc.maxTraffic(adj);
		
		System.out.println();
		mc.maxTraffic(adj2);
	}
	
	public void maxTraffic(int[][] adj) {				
		
		// build Graph
		int grandTotal = 0;
		int idx = 0;
		Map<Integer, Node> nodeMap = new HashMap<>();
		for (int i = 0; i < adj.length; i++) {
			int n1 = adj[i][0];
			int n2 = adj[i][1];
			
			Node node1 = null;
			if (!nodeMap.containsKey(n1)) {
				node1 = new Node(n1, idx);
				grandTotal += n1;
				idx++;
			} else {
				node1 = nodeMap.get(n1);
			}

			Node node2 = null;
			if (!nodeMap.containsKey(n2)) {
				node2 = new Node(n2, idx);
				grandTotal += n2;
				idx++;
			} else {
				node2 = nodeMap.get(n2);
			}

			node1.neighbors.add(node2);
			node2.neighbors.add(node1);
			
			if (!nodeMap.containsKey(n1)) {
				nodeMap.put(n1, node1);
			}
			if (!nodeMap.containsKey(n2)) {
				nodeMap.put(n2, node2);
			}
		}

		// iterate over graph and print maxTraffic for each node
		for(Map.Entry<Integer, Node> e : nodeMap.entrySet()) {			
			System.out.println(e.getKey() + " " + maxTraffic(e.getValue(), grandTotal));			
		}		
	}
	
	private int maxTraffic(Node node, int grandTotal) {
		if (node.neighbors.size() == 1) { // case of leaf 
			return grandTotal - node.val;
		} 
		int maxLocal = -1;
		for(Node n2: node.neighbors) {											
			maxLocal = Math.max(maxLocal, sumSubtree(n2, node));
		}
		return maxLocal;		
	}	

	private int sumSubtree(Node root, Node excluded) {
		int sum = root.val;
		for(Node n2 : root.neighbors) {
			if (!n2.equals(excluded)) {
				sum += sumSubtree(n2, root);
			}
		}
		return sum;
	}
}

class Node {	
	int i;
	int val;
	Set<Node> neighbors;
	public Node(int val, int i) {
		super();
		this.i = i;
		this.val = val;
		this.neighbors = new HashSet<>();
	}	
}
