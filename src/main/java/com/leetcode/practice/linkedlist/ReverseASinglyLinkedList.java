package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class ReverseASinglyLinkedList {
	
	// My solution which is efficient also. TC O(N) SC O(1)
	public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(slowNode.next != null) {
            fastNode = slowNode.next;
            if(fastNode.next == null) {
                slowNode.next = null;
            } else {
                slowNode.next = fastNode.next;
            }
            fastNode.next = head;
            head = fastNode;
        };
        return head;
    }
	
	// GFG Solution
	ListNode reverse(ListNode node)
    {
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
