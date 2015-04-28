package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=10343
 *
 */
public class FriendScore {

	public static void main(String[] args) {
		solveHighestScore2Friend();
	}

	public static void solveHighestScore2Friend() {
		String[] s = { "NNN", "NNN", "NNN" };
		System.out.println(highestScore(s));
		
		String[] s1 = {"NYY", "YNY", "YYN"};
		System.out.println(highestScore(s1));
		
		String[] s2 = {"NYNNN",
				 "YNYNN", 
				 "NYNYN", 
				 "NNYNY", 
				 "NNNYN"};
		System.out.println(highestScore(s2));

		String[] s3 = {"NNNNYNNNNN",
				 "NNNNYNYYNN",
				 "NNNYYYNNNN",
				 "NNYNNNNNNN",
				 "YYYNNNNNNY",
				 "NNYNNNNNYN",
				 "NYNNNNNYNN",
				 "NYNNNNYNNN",
				 "NNNNNYNNNN",
				 "NNNNYNNNNN"};
		System.out.println(highestScore(s3));

		String[] s4 = {"NNNNNNNNNNNNNNY",
				 "NNNNNNNNNNNNNNN",
				 "NNNNNNNYNNNNNNN",
				 "NNNNNNNYNNNNNNY",
				 "NNNNNNNNNNNNNNY",
				 "NNNNNNNNYNNNNNN",
				 "NNNNNNNNNNNNNNN",
				 "NNYYNNNNNNNNNNN",
				 "NNNNNYNNNNNYNNN",
				 "NNNNNNNNNNNNNNY",
				 "NNNNNNNNNNNNNNN",
				 "NNNNNNNNYNNNNNN",
				 "NNNNNNNNNNNNNNN",
				 "NNNNNNNNNNNNNNN",
				 "YNNYYNNNNYNNNNN"};
		
		System.out.println(highestScore(s4));

	}

	public static int highestScore(String[] friends) {
		GraphFriendScore g = getGraphFromInputStrings(friends);
		return highestScore(g);
	}
	private static int highestScore(GraphFriendScore g) {
		int max = 0;
		for (NodeFriendScore n : g.nodes) {
			max = Math.max(max, findMax2FriendOfNode(n));
		}
		return max;
	}

	private static int findMax2FriendOfNode(NodeFriendScore n) {
		int sum = 0;
		NodeFriendScore y = null;
		Set<NodeFriendScore> directF = new HashSet<>(), indirectF = new HashSet<>();

		for (EdgeFriendScore e : n.edges) {
			y = e.n1.equals(n) ? e.n2 : e.n1;
			directF.add(y);
		}

		for (NodeFriendScore n2 : directF) {
			for (EdgeFriendScore e : n2.edges) {
				y = e.n1.equals(n2) ? e.n2 : e.n1;
				if (!y.equals(n) && !directF.contains(y)) {
					indirectF.add(y);
				}
			}
		}

		sum = directF.size() + indirectF.size();
		return sum;
	}

	private static GraphFriendScore getGraphFromInputStrings(String[] s) {
		GraphFriendScore g = new GraphFriendScore();
		List<NodeFriendScore> nodes = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			NodeFriendScore nd = new NodeFriendScore(i);
			nodes.add(nd);
		}
		NodeFriendScore n = null;
		char[] c = null;

		for (int i = 0; i < s.length; i++) {
			n = nodes.get(i);
			c = s[i].toCharArray();
			for (int j = 0; j < c.length; j++) {
				if (c[j] == 'Y' && j != i) {
					EdgeFriendScore e = new EdgeFriendScore(n, nodes.get(j), 1);
					n.edges.add(e);
				}
			}
		}

		g.nodes = nodes;
		return g;
	}

}

class GraphFriendScore {
	List<NodeFriendScore> nodes;

	public GraphFriendScore() {
		nodes = new ArrayList<>();
	}
}

class NodeFriendScore {
	int val;
	Set<EdgeFriendScore> edges;

	public NodeFriendScore() {
		this.edges = new HashSet<>();
	}

	public NodeFriendScore(int val) {
		super();
		this.edges = new HashSet<>();
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
		NodeFriendScore other = (NodeFriendScore) obj;
		if (val != other.val)
			return false;
		return true;
	}

}

class EdgeFriendScore {
	int weight;
	NodeFriendScore n1;
	NodeFriendScore n2;

	public EdgeFriendScore(NodeFriendScore n1, NodeFriendScore n2, int weight) {
		super();
		this.weight = weight;
		this.n1 = n1;
		this.n2 = n2;
	}
}
