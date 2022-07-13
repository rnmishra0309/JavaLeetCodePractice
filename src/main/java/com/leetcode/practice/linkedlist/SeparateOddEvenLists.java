package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

/**
 * My Question:
 * Separate odd values in left and right respectively.
 * @author RudraNM
 *
 */
public class SeparateOddEvenLists {
	public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode slowNode = null, fastNode = head, tailNode = head;
        while(tailNode.next != null) tailNode = tailNode.next;
        while(fastNode != tailNode && fastNode.next != tailNode) {
            if(fastNode.val % 2 != 0) {
                slowNode = fastNode;
                fastNode = fastNode.next;
            } else {
                slowNode.next = fastNode.next;
                fastNode.next = null;
                tailNode.next = fastNode;
                tailNode = fastNode;
                fastNode = slowNode.next;
            }
        }
        return head;
    }
}
