package com.guilhebl.algo.list;

/**
 * 
 * https://careercup.com/question?id=5761604919492608
 *
 */
public class ListCycleMetrics {

	public static int meetingIndexPoint(ListNodeCycle head) {
		if (head == null) {
			return -1;
		}
		ListNodeCycle fast = head;
		ListNodeCycle slow = head;
		boolean foundLoop = false;
		
		int k = 1;
		while (fast != null && fast.next != null && !foundLoop) {
			slow = slow.next;
			fast = fast.next.next;
			k+=2;
			if (slow == fast) {
				foundLoop = true;
			}
		}
		
		if (fast == null || fast.next == null) {
			return -1;
		}
		
		int c2 = 1;
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
			c2++;
		}		
		return c2;
	}
}
class ListNodeCycle {
	int val;
	ListNodeCycle next;
	public ListNodeCycle(int val) {
		super();
		this.val = val;
	}
}
