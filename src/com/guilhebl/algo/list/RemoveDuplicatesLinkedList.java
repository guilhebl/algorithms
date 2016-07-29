package com.guilhebl.algo.list;

/**
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
        	return null;
        }
    	
    	ListNode temp = new ListNode(0);    	
        ListNode curr = temp;        
        ListNode next = head;
        curr.next = next;
        
        while(next	 != null) {        	
        	while(next.next != null && next.val == next.next.val) {
        		next = next.next;
        	}

        	if (curr.val == next.val) {
        		curr.next = next.next;
        		next = curr.next;
        	} else {
        		curr = curr.next;
        		next = next.next;
        	}        	
        }
    	return temp.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
