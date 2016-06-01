package com.guilhebl.algo.tree;

/**
 * http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 *
 */
public class ValidateArrayInOrderTraversal {

	public static void main(String[] args) {		
		int[] a = {6,3,2,4,8,7,9};
		System.out.println(isValidInOrderTraversal(a));
	}
	public static boolean isValidInOrderTraversal(int[] a) {
		if (a == null || a.length == 0) {
			return false;
		}
		if (a.length == 1 || a.length == 2) {
			return true;
		}		
		return isValidInOrderTraversal(a, 0, a.length-1);
	}
	
	public static boolean isValidInOrderTraversal(int[] a, int l, int r) {
		if (a == null || a.length == 0 || l > r) {
			return false;
		}
		if (l == r) {
			return true;
		}
		int root = a[l];
		int l1 = l + 1;
		while(l1 < r && l1 < a.length && a[l1] < root) {
			l1++;
		}					
		int r1 = l1;
		while(a[r1] > root && r1 < r && r1 < a.length) {
			r1++;
		}	
		if (r1 != r) {
			return false;
		}			
		
		return isValidInOrderTraversal(a, l + 1, l1) && isValidInOrderTraversal(a, l1, r1);
	}
	
	
}
