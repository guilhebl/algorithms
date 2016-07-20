package com.guilhebl.algo.tree;

/**
 * 
 * Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree
 *
 */
public class FirstCommonAncestorBinaryTree {

	public static ResultAncBinTree findCommonAncestor(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		if (root == null) {
			return new ResultAncBinTree(false, null);
		}
		
		if (root == a && root == b) {
			return new ResultAncBinTree(true, root);
		}
		
		ResultAncBinTree lr = findCommonAncestor(root.left, a, b);
		if (lr.isAnc) {
			return lr;
		}
		
		ResultAncBinTree rr = findCommonAncestor(root.right, a, b);
		if (rr.isAnc) {
			return rr;
		}

		if (lr != null && rr != null) {
			return new ResultAncBinTree(true, root);
		}
		if (root == a || root == b) {
			return new ResultAncBinTree(lr != null || rr != null, root);
		}
		
		return new ResultAncBinTree(false, lr != null ? lr.node : rr.node);
	}
}

class ResultAncBinTree {
	boolean isAnc;
	BinaryTreeNode node;
	public ResultAncBinTree(boolean isAnc, BinaryTreeNode node) {
		super();
		this.isAnc = isAnc;
		this.node = node;
	}
}

class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode(int val) {
		super();
		this.val = val;
	}
}
