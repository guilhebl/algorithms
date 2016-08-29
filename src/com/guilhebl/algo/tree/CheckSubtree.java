package com.guilhebl.algo.tree;

/**
 * 
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with
hundreds of nodes. Create an algorithm to decide ifT2 is a subtree ofTl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree ofn
is identical to T2. That is, if you cut off the tree at node n, the two trees would be
identical.
 *
 */
public class CheckSubtree {

	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		return isSubtreeValid(t1.left, t2.left);
	}
	
	public static boolean isSubtreeValid(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return false;
		}
		if (t1.val == t2.val && isMatchingSubtree(t1, t2)) {
			return true;
		}
		
		return isSubtreeValid(t1.left, t2) || isSubtreeValid(t1.right, t2);
	}

	private static boolean isMatchingSubtree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t2 == null || t1 == null) {
			return false;
		}
		if (t1.val != t2.val) {
			return false;
		}
		
		return isMatchingSubtree(t1.left, t2.left) && 
				isMatchingSubtree(t1.right, t2.right);
	}
	
}
