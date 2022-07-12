package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class CycleInSLL {
	// My Solution at first attempt - runtime beats (44.57%) memory beats (65.24%)
	// space comp: O(1) time comp: O(N)
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
	
	// find beginning of the loop -> From Cracking The Coding Interview
	// leetcode -> runtime beats 100% of java solution, memory usage beats 92.60%.
	public ListNode findBeginning(ListNode head) {
		if(head == null || head.next == null) {
            return null;
        }
		ListNode slow = head;
        ListNode fast = head;
        boolean collisionFound = false;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ // collision
            	collisionFound = true;
                break;
            }
        }
        
        if(collisionFound) {
        	slow = head;
        	while(slow != fast) {
        		slow = slow.next;
        		fast = fast.next;
        	}
        	return fast;
        }
        return null;
	}
}
