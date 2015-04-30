package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=9824
 *
 */
public class CorporationSalary {

	private static final int VISITING = 1;
	private static final int VISITED = 2;

	public static void main(String[] args) {
		solveCorporationSalary();
	}
	
	public static void solveCorporationSalary() {
		String[] a0 = {"N"};
			System.out.println(totalSalary(a0));
		
		String[] a = {"NNYN",
			 "NNYN",
			 "NNNN",
			 "NYYN"};
		System.out.println(totalSalary(a));
		
		String[] a2 = {"NNNNNN",
				 "YNYNNY",
				 "YNNNNY",
				 "NNNNNN",
				 "YNYNNN",
				 "YNNYNN"};		
		System.out.println(totalSalary(a2));

		String[] a3 = {"NYNNYN",
				 "NNNNNN",
				 "NNNNNN",
				 "NNYNNN",
				 "NNNNNN",
				 "NNNYYN"};				
		System.out.println(totalSalary(a3));

		String[] a4 = {"NNNN",
				 "NNNN",
				 "NNNN",
				 "NNNN"};		
		System.out.println(totalSalary(a4));

	}
	
	
	public static long totalSalary(String[] relations) {	
		long sum = 0;		
		int state[] = new int[relations.length];
		Map<Integer, NodeCS> mapNodes = new HashMap<>();
		char[] c = null;
		NodeCS nd = null, nd2 = null;
		
		for (int i = 0; i < relations.length; i++) {
			if (mapNodes.containsKey(i)) {
				nd = mapNodes.get(i);
			} else {
				nd = new NodeCS(i);
			}						
			c = relations[i].toCharArray();
						
			for (int j = 0; j < c.length; j++) {
				if (i != j && c[j] == 'Y') {					
					if (!mapNodes.containsKey(j)) {
						nd2 = new NodeCS(j);
					} else {
						nd2 = mapNodes.get(j);
					}
					nd.children.add(nd2);
					mapNodes.put(j,nd2);					
				}
			}
			mapNodes.put(i,nd);
		}		
		
		for(Map.Entry<Integer, NodeCS> e : mapNodes.entrySet()) {
			sum += getSalary(e.getValue(), state);
		}
			
		return sum;		
	}
	
	public static long getSalary(NodeCS root, int[] state) {
		if (root == null) {
			return 0;
		}
		if (state[root.i] == VISITED) {
			return root.sal;
		}
		if (root.children == null || root.children.isEmpty()) {
			root.sal = 1;
			state[root.i] = VISITED;
			return 1;
		}
		
		state[root.i] = VISITING;
		long sum = 0;
		for(NodeCS c : root.children) {
			sum += getSalary(c, state);
		}
		root.sal = sum;
		state[root.i] = VISITED;
		
		return sum;
	}
}

class NodeCS {
	
	int i;
	long sal;
	List<NodeCS> children;
	
	public NodeCS(int i) {
		this.children = new ArrayList<>();
		this.i = i;
		sal = 0;
	}		
}