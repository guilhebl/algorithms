package com.guilhebl.algo.list;

/**
 * 
 * You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
of the list. Write a function that adds the two numbers and returns the sum as a
linked list.
 *
 */
public class ListNumberAdd {

	public static void main(String[] args) {
		testAddNode();
	}
	
	public static void testAddNode() {
		
		// List A - number 52917
		ListAddNode l1 = new ListAddNode(7);
		l1.next = new ListAddNode(1);
		l1.next.next = new ListAddNode(9);
		l1.next.next.next = new ListAddNode(2);
		l1.next.next.next.next = new ListAddNode(5);
		
		// List B - number 295
		ListAddNode l2 = new ListAddNode(5);
		l2.next = new ListAddNode(9);
		l2.next.next = new ListAddNode(2);

		// total : 53212
		ListAddNode r = addLists(l1, l2);
		
		printList(r);
	}
	
	public static void printList(ListAddNode r) {
		while (r != null) {
			System.out.print(r.val + "->");
			r = r.next;
		}
	}
	
	public static ListAddNode addLists(ListAddNode l1, ListAddNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int carry = 0;
		ListAddNode head = null;
		ListAddNode tail = null;
		
		int sum = 0;
		while (l1 != null && l2 != null) {
			sum = carry + l1.val + l2.val;
			carry = sum / 10;
			sum = sum % 10;
			if (head == null) {
				head = new ListAddNode(sum);
				tail = head;
			} else {
				tail.next = new ListAddNode(sum);
				tail = tail.next;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null) {
			sum = carry + l1.val;
			carry = sum > 0 ? sum / 10 : 0;
			sum = sum > 0 ? sum % 10 : sum;

			tail.next = new ListAddNode(sum);
			tail = tail.next;
			l1 = l1.next;
		}
		
		while (l2 != null) {
			sum = carry + l2.val;
			carry = sum > 0 ? sum / 10 : 0;
			sum = sum > 0 ? sum % 10 : sum;

			tail.next = new ListAddNode(sum);
			tail = tail.next;
			l2 = l2.next;
		}
		return head;
	}
	
}

class ListAddNode {
	int val;
	ListAddNode next;
	public ListAddNode(int val) {
		this.val = val;
	}
}
