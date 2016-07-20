package com.guilhebl.algo.tree;

/**
 * 
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
a binary search tree. You may assume that each node has a link to its parent.
 *
 */
public class InOrderSuccessorBST {

	public InOrderSuccessorBSTNode findInOrderSuccessorBST(InOrderSuccessorBSTNode root) {
		if (root == null) {
			return null;
		}
		
		// try leftmost right tree node
		InOrderSuccessorBSTNode right = root.right;
		if (right != null) {
			while (right.left != null) {
				 right = right.left;
			}
			return right;
		}
		
		// find first parent from left upper tree
		InOrderSuccessorBSTNode temp = root;
		InOrderSuccessorBSTNode p = root.parent;
		while (p != null && p.right == temp) {
			temp = p;
			p = p.parent;
		}
		
		return p;
	}
}
class InOrderSuccessorBSTNode {
	int val;
	InOrderSuccessorBSTNode parent;
	InOrderSuccessorBSTNode left;
	InOrderSuccessorBSTNode right;
}