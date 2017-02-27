package com.guilhebl.algo.list;

/**
 * 
 * https://careercup.com/question?id=5637167285010432
 *
 */
public class SwapKthElements {

	public static void main(String[] args) {
		ListNodePartition head = new ListNodePartition(1);
		head.next = new ListNodePartition(2);
		head.next.next = new ListNodePartition(4);
		head.next.next.next = new ListNodePartition(5);
		head.next.next.next.next = new ListNodePartition(7);
		head.next.next.next.next.next = new ListNodePartition(8);
		head = swapKthElements(head, 2);
		printList(head);
	}
	
	private static void printList(ListNodePartition head) {
		ListNodePartition n = head;
		while(n != null) {
			System.out.print(n.val + " - ");
			n = n.next;
		}
	}

	public static ListNodePartition swapKthElements(ListNodePartition head, int k) {
		int i = 1; // start from head as index 1
		
		ListNodePartition node = head;
		ListNodePartition node1 = null;
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
		ListNodePartition node2 = null;
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
