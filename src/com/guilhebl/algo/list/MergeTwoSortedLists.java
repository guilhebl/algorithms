package com.guilhebl.algo.list;

/**
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */
public class MergeTwoSortedLists {

	public ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        
        if (l1 == null && l2 == null) {
        	return null;
        } else if (l1 == null) {
        	return l2;
        } else if (l2 == null) {
        	return l1;
        }		
		
        ListNode2 dummy = new ListNode2(0);
        
        ListNode2 curr1 = l1;
        ListNode2 curr2 = l2;

        ListNode2 head = new ListNode2(0);
        dummy.next = head;

        while(curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                head.next = curr1;
                curr1 = curr1.next;
                head = head.next;
            }
            else if (curr1.val > curr2.val) {
                head.next = curr2;
                curr2 = curr2.next;
                head = head.next;
            }
        }
        
        while(curr1 != null) {
            head.next = curr1;
            curr1 = curr1.next;
            head = head.next;
        }
        while(curr2 != null) {
            head.next = curr2;
            curr2 = curr2.next;
            head = head.next;
        }
        
        return dummy.next.next;
    }
}

 class ListNode2 {
    int val;
     ListNode2 next;
     ListNode2(int x) { val = x; }
 }