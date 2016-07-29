package com.guilhebl.algo.list;

/**
 * 
 * https://careercup.com/question?id=5637167285010432
 *
 */
public class SwapKthElements {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next = new ListNode(8);
		head = swapKthElements(head, 2);
		printList(head);
	}
	
	private static void printList(ListNode head) {
		ListNode n = head;
		while(n != null) {
			System.out.print(n.val + " - ");
			n = n.next;
		}
	}

	public static ListNode swapKthElements(ListNode head, int k) {
		int n = 0;
		int i = 1; // start from head as index 1
		
		ListNode node = head;
		ListNode node1 = null;
		while (node != null) {
			if (i == k) {
				node1 = node;
			}
			node = node.next;
			i++;
		}
		int i2 = i - k; // kth from last 
		node = head;
		i = 1;
		ListNode node2 = null;
		while(node != null) {
			if (i == i2) {
				node2 = node;
			}
			node = node.next;
			i++;
		}
	
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
		return head;
	}
}

//class ListNode {
//	int val;
//	ListNode next;
//	public ListNode(int val) {
//		super();
//		this.val = val;
//	}
//}