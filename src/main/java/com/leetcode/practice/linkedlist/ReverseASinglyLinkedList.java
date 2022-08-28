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
	
	// Recursive solution - My solution
	public ListNode reverseListRecursive(ListNode head) {
        if(head == null) return head;
        return reverseListRecurse(head)[0];
    }
    
    public ListNode[] reverseListRecurse(ListNode head) {
        ListNode[] result = new ListNode[2];
        if(head.next == null) {
            ListNode tail = head;
            result[0] = tail;
            result[1] = head;
            return result;
        }
        ListNode[] getArray = reverseListRecurse(head.next);
        ListNode tail = getArray[0];
        ListNode fast = getArray[1];
        ListNode slow = head;
        slow.next = null;
        fast.next = slow;
        result[0] = tail;
        result[1] = slow;
        return result;
    }
    
    // Leetcode recursive efficient solutioh
    public ListNode reverseListLeetcode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListLeetcode(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
