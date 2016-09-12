package com.guilhebl.algo.list;

/**
 * 
 * https://leetcode.com/problems/partition-list/
 *
 */
public class PartitionList {

	public static void main(String[] args) {
		ListNodePartition l1 = new ListNodePartition(2);
		l1.next = new ListNodePartition(1);
		
		printList(partition(l1, 2));
	}
	
    private static void printList(ListNodePartition n) {
    	while(n != null) {
    		System.out.print(n.val + " -> ");
    		n = n.next;
    	}
		
	}

	public static ListNodePartition partition(ListNodePartition head, int x) {
    	if (head == null || head.next == null) return head;
    	ListNodePartition beforeXStart = null;
    	ListNodePartition beforeXEnd = null;
    	ListNodePartition afterXStart = null;
    	ListNodePartition afterXEnd = null;
    	
    	ListNodePartition curr = head;
    	while(curr != null) {
    		if (curr.val < x) {
    			if (beforeXStart == null) {
    				beforeXStart = curr;
    				beforeXEnd = curr;
    			} else {
        			beforeXEnd.next = curr;    			
        			beforeXEnd = beforeXEnd.next;    				
    			}
    		} else {
    			if (afterXStart == null) {
    				afterXStart = curr;
    				afterXEnd = curr;
    			} else {
        			afterXEnd.next = curr;    			
        			afterXEnd = afterXEnd.next;    				
    			}
    		}    		    		
    		curr = curr.next;
    	}
    	if (beforeXEnd == null) {
    		return head;
    	}
    	beforeXEnd.next = afterXStart;
    	afterXEnd.next = null;
    	
    	return beforeXStart;
    }
}
class ListNodePartition {
     int val;
     ListNodePartition next;
     ListNodePartition(int x) { val = x; }
}