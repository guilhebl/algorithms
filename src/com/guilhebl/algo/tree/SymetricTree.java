package com.guilhebl.algo.tree;

/**
 * 
 * https://leetcode.com/problems/symmetric-tree/
 * https://leetcode.com/problems/same-tree/
 */
public class SymetricTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p != null && q == null || p == null && q != null || p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && 
				isSameTree(p.right, q.right);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymetric(root.left, root.right);
	}

	public boolean isSymetric(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null && t2 != null || t1 != null && t2 == null || t1.val != t2.val) {
			return false;
		}

		return isSymetric(t1.left, t2.right) && isSymetric(t1.right, t2.left);
	}
}
