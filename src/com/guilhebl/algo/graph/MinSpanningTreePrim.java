package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Prim's Minimum Spanning Tree algorithm 
 * 
 * @author root
 *
 */
public class MinSpanningTreePrim {

	public static void main(String[] args) {
		Graph g = new Graph();
		List<NodeG> list = new ArrayList<>();
		NodeG n1 = new NodeG(0);
		NodeG n2 = new NodeG(1);
		NodeG n3 = new NodeG(2);
		NodeG n4 = new NodeG(3);

		Edge e1 = new Edge(n1, n2, 2);
		Edge e2 = new Edge(n1, n3, 1);
		Edge e3 = new Edge(n2, n3, 2);
		Edge e4 = new Edge(n3, n4, 3);

		Set<Edge> edges = new HashSet<Edge>();
		edges.add(e1);
		edges.add(e2);
		n1.edges = edges;

		edges = new HashSet<Edge>();
		edges.add(e1);
		edges.add(e3);
		n2.edges = edges;

		edges = new HashSet<Edge>();
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		n3.edges = edges;

		edges = new HashSet<Edge>();
		edges.add(e4);
		n4.edges = edges;

		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		g.nodes = list;

		printEdges(getMinSpanningTree(g, 0));
	}

	public static void printEdges(Set<Edge> edges) {
		for (Edge edge : edges) {
			System.out.println(edge.n1.val + " -- " + edge.weight + " -- "
					+ edge.n2.val);
		}
	}

	public static Set<Edge> getMinSpanningTree(Graph g, int start) {
		int i, v, w, weight, dist;
		NodeG n = null;
		Set<Edge> edges = null;
		boolean inTree[] = new boolean[g.nodes.size()];
		int parent[] = new int[g.nodes.size()];
		int distance[] = new int[g.nodes.size()];
		Set<Edge> minTree = new HashSet<>();

		List<NodeG> nodes = g.nodes;
		for (i = 0; i < nodes.size(); i++) {
			inTree[i] = false;
			parent[i] = -1;
			distance[i] = Integer.MAX_VALUE;
		}

		distance[start] = 0;
		v = start;

		while (!inTree[v]) {
			inTree[v] = true;
			n = nodes.get(v);
			if (v != start) {
				for (Edge e : n.edges) {
					if (e.n1.val == parent[v] || e.n2.val == parent[v]) {
						minTree.add(e);
					}
				}
			}

			edges = n.edges;
			for (Edge e : edges) {
				w = e.n1.equals(n) ? e.n2.val : e.n1.val;
				weight = e.weight;
				if ((distance[w] > weight) && !inTree[w]) {
					distance[w] = weight;
					parent[w] = v;
				}
			}

			v = 0;
			dist = Integer.MAX_VALUE;
			for (i = 0; i < nodes.size(); i++) {
				if (!inTree[i] && (dist > distance[i])) {
					dist = distance[i];
					v = i;
				}
			}

		}

		return minTree;
	}

}
class Edge {
	int weight;
	NodeG n1;
	NodeG n2;

	public Edge(NodeG n1, NodeG n2, int weight) {
		super();
		this.weight = weight;
		this.n1 = n1;
		this.n2 = n2;
	}

}

class Graph {
	List<NodeG> nodes;

	public Graph() {
		nodes = new ArrayList<>();
	}
}

class NodeG {
	int val;
	Set<Edge> edges;

	public NodeG() {
	}

	public NodeG(int val) {
		super();
		this.val = val;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeG other = (NodeG) obj;
		if (val != other.val)
			return false;
		return true;
	}

}