package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphMaxPath { 
	
	public static void main(String[] args) {
		NodeDAG n1 = new NodeDAG(3);
		NodeDAG n2a = new NodeDAG(9);
		NodeDAG n2b = new NodeDAG(4);
		NodeDAG n3a = new NodeDAG(1);
		NodeDAG n3b = new NodeDAG(8);
		NodeDAG n3c = new NodeDAG(2);
		NodeDAG n4a = new NodeDAG(4);
		NodeDAG n4b = new NodeDAG(5);
		NodeDAG n4c = new NodeDAG(8);
		NodeDAG n4d = new NodeDAG(2);
		
		List<NodeDAG> children = new ArrayList<>();
		children.add(n2a);
		children.add(n2b);
		n1.children = children;

		children = new ArrayList<>();
		children.add(n3a);
		children.add(n3b);
		n2a.children = children;

		children = new ArrayList<>();
		children.add(n3b);
		children.add(n3c);
		n2b.children = children;

		children = new ArrayList<>();
		children.add(n4a);
		children.add(n4b);
		n3a.children = children;

		children = new ArrayList<>();
		children.add(n4b);
		children.add(n4c);
		n3b.children = children;

		children = new ArrayList<>();
		children.add(n4c);
		children.add(n4d);
		n3c.children = children;

		solveMaxPath(n1);
	}

	
	public static void solveMaxPath(NodeDAG root) {
		if (root == null) {
			return;
		}
		
		int sum = 0;
		int maxSum = 0;
		
		List<NodeDAG> path = new ArrayList<>();
		MaxPathSum mp = new MaxPathSum();
		findMaxPath(root, sum, maxSum, path, mp);
		
		printPath(mp.maxPath);
	}

	private static void printPath(List<NodeDAG> maxPath) {
		for (NodeDAG nodeDAG : maxPath) {
			System.out.print(nodeDAG.v + " ");
		}
	}

	private static void findMaxPath(NodeDAG root, int sum, Integer maxSum, List<NodeDAG> path, MaxPathSum maxPathSum) {
		if (root == null) {
			return;
		}
		
		sum += root.v;
		path.add(root);
		
		if (sum > maxPathSum.max) {
			maxPathSum.max = sum;
			maxPathSum.maxPath = path;
		}
		
		if (root.children != null && !root.children.isEmpty()) {
			for (NodeDAG nodeDAG : root.children) {
				findMaxPath(nodeDAG, sum, maxSum, new ArrayList<NodeDAG>(path), maxPathSum);
			}			
		}
	}
	
}

class MaxPathSum {
	int max;
	List<NodeDAG> maxPath;
	public MaxPathSum() {
		this.max = 0;
		this.maxPath = new ArrayList<>();
	}		
}

class NodeDAG {
	int v;
	List<NodeDAG> children;

	public NodeDAG(int v) {
		super();
		this.v = v;
	}
	@Override
	public String toString() {
		return new Integer(v).toString();
	}
}
