package com.guilhebl.algo.tree;

/**
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class ReconstructTree {

	/**
	 *   4 
	 * 2   6 
	 *1 3 5 8
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] p = { 4, 2, 1, 3, 6, 5, 8 };
		int[] i = { 1, 2, 3, 4, 5, 6, 8 };

		TreeNode t = buildTree(p, i);
		printTree(t);
	}

	private static void printTree(TreeNode t) {
		if (t == null) return;
		printTree(t.left);
		System.out.println(t.val);
		printTree(t.right);		
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int iPre, int jPre, int iIor, int jIor) {
		if (iPre > jPre || iIor > jIor) return null;
		TreeNode root = new TreeNode(preorder[iPre]);
		int indexOfRoot = -1;
		for (int i = iIor; i <= jIor && i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				indexOfRoot = i;
				break;
			}
		}
		root.left = buildTree(preorder, inorder, iPre + 1, iPre + (indexOfRoot - iIor), iIor, indexOfRoot - 1);
		root.right = buildTree(preorder, inorder, iPre + (indexOfRoot - iIor) + 1, jPre, indexOfRoot + 1, jIor);
		return root;
	}

}
