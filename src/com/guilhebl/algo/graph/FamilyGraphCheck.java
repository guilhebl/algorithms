package com.guilhebl.algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Check if a family is possible to be formed based on 2 int arrays.
 * 
 * Ex:
 * 
		int[] b1 = {-1,-1,0};
		int[] b2 = {-1,-1,1};

 * 
 * each index of arrays i, will represent 1 node and it's 2 parents, -1 represents NO PARENT, 
 * for example in the above array:
 * 
 * Node 0: b1[0], b2[0] -> parents none: (-1), (-1) 
 * Node 1: b1[1], b2[1] -> parents none: (-1), (-1)
 * Node 2: b1[2], b2[2] -> parents Node 0 and Node 1: 0,1 --> Is this a possible child ? Yes since both parents can be from opposite sexes,
 * like Node 0 - Male , Node 1 - Female , or the opposite. 
 * 
 * Ex:
 * 
 * 	 * {-1,-1,0,0,1}
       {-1,-1,1,2,2}
       
   Is this a possible Family Linage?
       
 * Node 0: (-1),(-1) - YES 
 * Node 1: (-1),(-1) - YES
 * Node 2: 0,1 - YES 
 * Node 3: 0,2 - YES -> But Node 2 must be of same sex that Node 1 since both have a child with Node 0. ( 0 - Male, 1 -Female, 2 - Female ) or ( 0 - Female, 1 - Male, 2 - Male)
 * Node 4: 1,2 - NO -> Since Node 2 must be of same sex of Node 1 then these aren't possible parents.
 * 
 */
public class FamilyGraphCheck {

public static void main(String[] args) {
		
		int[] b1 = {-1,-1,0};
		int[] b2 = {-1,-1,1};
		System.out.println(isFamily(b1, b2));

		int[] a1 = {-1,-1,0,0,1};
		int[] a2 = {-1,-1,1,2,2};		
		System.out.println(isFamily(a1, a2));

		
		int c1[] = {-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6};
	    int c2[] = {-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1};
	    System.out.println(isFamily(c1,c2));
	    
	    int d1[] = {-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11};
	    int d2[] = {-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13};
	    System.out.println(isFamily(d1,d2));
	}
	
	/**
	 * {-1,-1,0,0,1}
       {-1,-1,1,2,2}

	 * @param parent1
	 * @param parent2
	 * @return
	 */
	public static String isFamily(int[] parent1, int[] parent2) {
		if (parent1 == null || parent1.length == 0 || parent2 == null 
				|| parent2.length == 0 || parent1.length != parent2.length ) {
			return null;
		}
		
		List<NodeF> nodes = new ArrayList<>();
		boolean isFamily = true;
		int n = parent1.length;
		int counter = 0;
		int p1, p2;
		NodeF nd = null;

		for (int i = 0; i < n && isFamily; i++) {
			p1 = parent1[i];
			p2 = parent2[i];
									
			if (p1 == -1 && p2 == -1) {
				nd = new NodeF(counter++, 0, null, null);
				nodes.add(nd);
			} else if (p1 != p2) {				
				if (!isPossible(nodes, p1, p2)) {
					isFamily = false;
				} else {
					nd = new NodeF(counter++, 0, nodes.get(p1), nodes.get(p2));
					nodes.add(nd);
				}
			}
		}
		return isFamily ? "Possible" : "Impossible";
	}

	private static boolean isPossible(List<NodeF> nodes, int p1, int p2) {
		if (!nodes.contains(new NodeF(p1)) || !nodes.contains(new NodeF(p2))) {
			return false;
		}		
		NodeF p1n = nodes.get(p1);
		NodeF p2n = nodes.get(p2);
		
		if((p1n.gender == 0 && p2n.gender == 0)) {
			p1n.gender = 1;
			p2n.gender = 2;			
		} else if((p1n.gender == 1 && p2n.gender == 1)) {
			if (!p1n.swapped && !p2n.swapped) {
				p2n.gender = 2;
				p1n.swapped = true;
				p2n.swapped = true;
			} else {
				return false;
			}
		} else if((p1n.gender == 2 && p2n.gender == 2)) {		
			if (!p1n.swapped && !p2n.swapped) {
				p2n.gender = 1;
				p1n.swapped = true;
				p2n.swapped = true;
			} else {
				return false;
			}		
		} else if (p1n.gender == 0 && p2n.gender == 1) {
			p1n.gender = 2;
			p1n.swapped = true;
			p2n.swapped = true;
			
		} else if (p1n.gender == 1 && p2n.gender == 0) {
			p2n.gender = 2;
			p1n.swapped = true;
			p2n.swapped = true;

		} else if (p1n.gender == 2 && p2n.gender == 0) {
			p2n.gender = 1;
			p1n.swapped = true;
			p2n.swapped = true;

		} else if (p1n.gender == 0 && p2n.gender == 2) {
			p1n.gender = 1;
			p1n.swapped = true;
			p2n.swapped = true;

		}
		return true;
	}

}

class GraphF {
	List<NodeF> nodes;	
}

class NodeF {	
	int val;
	int gender; // 0 - undefined , 1 -- male, 2 -- female
	boolean swapped;
	NodeF father;
	NodeF mother;
	public NodeF(int val) {
		super();
		this.gender = 0;
		this.val = val;
		this.swapped = false;
	}

	public NodeF(int val, int gender, NodeF father, NodeF mother) {
		super();
		this.val = val;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
		this.swapped = false;
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
		NodeF other = (NodeF) obj;
		if (val != other.val)
			return false;
		return true;
	}	
	@Override
	public String toString() {
		return " " + val;
	}
}