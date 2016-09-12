package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 
 * Print all leaf subdomain sums as following samples:
 * 
 * 
 *  a.b.com	10
	google.com 5
	com -5
	b.com 10
	test.net	20
	net		10
 *
 *
 * a.b.com = 10 + 10 - 5
 *
 */
public class SubdomainSum {

	public static void main(String[] args) {
		Map<String, Integer> nodeMap = new HashMap<>();
		nodeMap.put("a.b.com", 10);
		nodeMap.put("google.com", 5);
		nodeMap.put("com", -5);
		nodeMap.put("b.com", 10);
		nodeMap.put("test.net", 20);
		nodeMap.put("net", 10);
		
		printSubdomainLeafs(nodeMap);
	}
	
	public static void printSubdomainLeafs(Map<String, Integer> map) {		
		HashSet<String> parents = new HashSet<>();
		List<SubdomainNode> list = new ArrayList<>();
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			int val = e.getValue();
			String label = e.getKey();
			if (!parents.contains(label)) {
				SubdomainNode n1 = new SubdomainNode(label, val);
				int sum = val;
				int idxParent = label.indexOf('.');
				
				while(idxParent != -1) {
					String parent = label.substring(idxParent + 1);
					parents.add(parent);
					sum += map.get(parent);											
					idxParent = label.indexOf('.', idxParent+1);
				}
				n1.total = sum;
				list.add(n1);
			}			
		}
		
		for (SubdomainNode subdomainNode : list) {
			if (!parents.contains(subdomainNode.label)) {
				System.out.println(subdomainNode.label + " " + subdomainNode.total);
			}
		}
		
	}
	
	
}

class SubdomainNode {
	String label;
	int val;
	int total;
	public SubdomainNode(String label, int val) {
		super();
		this.label = label;
		this.val = val;
	}
	
}