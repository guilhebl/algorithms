package com.guilhebl.algo.tree;

/**
 * 
 * Implement a function to check if a binary tree is a binary search tree.e
 *
 */
public class CheckValidBST {

	public static boolean isValidBST(TreeNodeBSTValid root) {
		if (root == null) {
			return true;
		}
		return isValidBSTUtil(root, null);
	}
	
	public static boolean isValidBSTUtil(TreeNodeBSTValid root, NumWrapper lastNumber) {
		if (root == null) {
			return true;
		}
		boolean isValid = isValidBSTUtil(root.left, lastNumber);
		if (lastNumber != null && lastNumber.val > root.val) {
			return false;
		}
		lastNumber = new NumWrapper(root.val);								
		isValid = isValidBSTUtil(root.right, lastNumber);
		return isValid;
	}
	
	// int min, int max version
	public static boolean isValidBST(TreeNodeBSTValid root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val > Integer.MAX_VALUE) {
			return false;
		}
		return isValidBST(root.left, min, root.val) && 
				isValidBST(root.right, root.val, max);
	}
	
	public static boolean isValidBSTMinMax(TreeNodeBSTValid root) {
		if (root == null) {
			return true;
		}
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
class NumWrapper {
	public NumWrapper(int val2) {
		this.val = val2;
	}
	int val;
}
class TreeNodeBSTValid {
	int val;
	TreeNodeBSTValid left;
	TreeNodeBSTValid right;
}
