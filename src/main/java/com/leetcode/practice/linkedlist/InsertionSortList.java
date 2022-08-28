package com.leetcode.practice.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.linkedlist.util.ListNode;

public class InsertionSortList {

	static final Logger logger = LogManager.getLogger(InsertionSortList.class);
	
	// My solution - solved with debugging
	public static ListNode insertionSortList(ListNode head) {
		ListNode prev = head;
		ListNode curr = prev.next;
		ListNode temp;
		while (prev != null && curr != null) {
			if (prev.val <= curr.val) {
				prev = prev.next;
				curr = prev.next;
			} else {
				prev.next = curr.next;
				curr.next = null;
				temp = head;
				if (temp.val > curr.val) {
					curr.next = head;
					head = curr;
				} else {
					while (temp != prev && temp.next.val < curr.val) {
						temp = temp.next;
					}
					curr.next = temp.next;
					temp.next = curr;
				}
				curr = prev.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.printHead();
		ListNode result = insertionSortList(head);
		result.printHead();
	}
}
