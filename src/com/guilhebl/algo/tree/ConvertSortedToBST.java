package com.guilhebl.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 1 2 3 4 5 6
 * 
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedToBST {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ConvertSortedToBST c = new ConvertSortedToBST();
		System.out.println(c.sortedListToBST(head));
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if (nums == null) return null;
    	return convertToTreeNode(nums, 0, nums.length-1);        
    }
    
	private TreeNode convertToTreeNode(int[] nums, int l, int h) {
		if (l > h) {
			return null;
		}
		int mid = l + ((h - l)/2);
		TreeNode root = new TreeNode(nums[mid]);
		root.left = convertToTreeNode(nums, l, mid-1);
		root.right = convertToTreeNode(nums, mid+1, h);
		return root;
	}

	public TreeNode sortedListToBST(ListNode head) {
		 if (head == null) {
			 return null;
		 }
		 List<Integer> list = new ArrayList<>();
		 while(head != null) {
			 list.add(head.val);
			 head = head.next;
		 }		 		 
		 TreeNode root = insertNode(list, 0, list.size()-1);
		 return root;
	 }

	private TreeNode insertNode(List<Integer> list, int l, int h) {
		if (l > h) {
			return null;
		}
		int mid = l + (h - l)/2;
		TreeNode t = new TreeNode(list.get(mid));
		t.left = insertNode(list, l, mid-1);
		t.right = insertNode(list, mid+1, h);		
		return t;
	}

}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }