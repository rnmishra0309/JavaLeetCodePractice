package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class RemoveElementsFromSLL {
	
	// Couldn't solved it. TC O(N) SC O(1)
	public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }
}
