package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class SeparateOddEvenIndices {
	// My solution
	public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode slowNode = head, fastNode = null, tailNode = head, lastNode = null;
        while(tailNode.next != null) tailNode = tailNode.next;
        lastNode = tailNode;
        while(slowNode.next != null && slowNode.next.next != null && slowNode != tailNode && fastNode != tailNode) {
            fastNode = slowNode.next;
            slowNode.next = fastNode.next;
            fastNode.next = null;
            lastNode.next = fastNode;
            lastNode = fastNode;
            slowNode = slowNode.next;
        }
        return head;
    }
	
	// A more efficient solution
	public ListNode oddEvenListEfficient(ListNode head) {
		if (head != null) {
			ListNode odd = head;
			ListNode even = head.next;
			ListNode evenHead = even;
			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				even = even.next;
				odd = odd.next;
				odd.next = evenHead;
			}
		}
		return head;
	}
}
