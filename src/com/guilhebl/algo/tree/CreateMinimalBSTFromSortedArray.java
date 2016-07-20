package com.guilhebl.algo.tree;

/**
 * 
 * Given a sorted (increasing order) array with unique integer elements, write an algo-
rithm to create a binary search tree with minimal height.
 *
 */
public class CreateMinimalBSTFromSortedArray {

	public static BSTSortedArrayNode createMinimalBSTFromSortedArray(int[] a, int l, int r) {
		if (l > r) {
			return null;
		}
		int mid = (l + r) / 2;
		BSTSortedArrayNode root = new BSTSortedArrayNode(a[mid]);
		root.left = createMinimalBSTFromSortedArray(a, l, mid - 1);
		root.right = createMinimalBSTFromSortedArray(a, mid + 1, r);
		return root;
	}
	
	public static BSTSortedArrayNode createMinimalBSTFromSortedArray(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		return createMinimalBSTFromSortedArray(a, 0, a.length - 1);
	}
	
}
class BSTSortedArrayNode {
	int val;
	BSTSortedArrayNode left;
	BSTSortedArrayNode right;
	public BSTSortedArrayNode(int val) {
		super();
		this.val = val;
	}
	
}
