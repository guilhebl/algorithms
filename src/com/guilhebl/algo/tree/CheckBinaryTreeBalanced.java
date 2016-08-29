package com.guilhebl.algo.tree;

public class CheckBinaryTreeBalanced {

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		int h = isBalancedUtil(root);
		return h != -1;
	}

	public static int isBalancedUtil(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftH = isBalancedUtil(root.left);
		if (leftH == -1) {
			return -1;
		}

		int rightH = isBalancedUtil(root.right);
		if (rightH == -1) {
			return -1;
		}
		
		if (Math.abs(leftH - rightH) > 1) {
			return -1;
		}

		return 1 + Math.max(leftH, rightH);
	}

}