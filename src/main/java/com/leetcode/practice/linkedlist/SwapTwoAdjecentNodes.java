package com.leetcode.practice.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.linkedlist.util.ListNode;

public class SwapTwoAdjecentNodes {
	
	static final Logger logger = LogManager.getLogger(SwapTwoAdjecentNodes.class);
	
	// Mysolution
	public static ListNode swapPairs(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        ListNode prev = head;
        head = swapPairs(head, slow, fast, prev);
        return head;
    }
    
    public static ListNode swapPairs(ListNode head, ListNode slow, ListNode fast, ListNode prev) {
        if(slow == null || fast == null) return head;
        slow.next = fast.next;
        fast.next = slow;
        if(slow == head) head = fast;
        else prev.next = fast;
        if(slow.next != null && fast.next != null)
            head = swapPairs(head, fast.next.next, slow.next.next, slow);
        return head;
    }
    
    // More cleaner code - Leetcode soln
    public ListNode swapPairsClean(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	//head.next.next.next = new ListNode(4);
    	head = swapPairs(head);
    	ListNode curr = head;
    	while(curr != null) {
    		logger.info(curr.val + " -> ");
    		curr = curr.next;
    	}
    }
	
}
