package com.guilhebl.algo.tree;

/**
 * 
 * Implement a function to check if a binary tree is a binary search tree.e
 *
 */
public class CheckValidBST {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(1);
		System.out.println(isValidBST(t));
	}
		
	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	// int min, int max version
	public static boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && 
				isValidBST(root.right, root.val, max);
	}
}
