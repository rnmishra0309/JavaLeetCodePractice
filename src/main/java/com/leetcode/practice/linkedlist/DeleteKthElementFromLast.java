package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class DeleteKthElementFromLast {
	
	// solved at first go with correct approach. O(N) TC, O(1) SC
	// this is the efficient solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        int temp = n, count = 1;
        if(head.next == null && n == 1) {
            head = null;
            return head;
        }
        while(temp-- != 0 && fastRunner.next != null) {
            fastRunner = fastRunner.next;
            count++;
        }
        if(fastRunner.next == null && n == count) {
            return head.next;
        }
        while(fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }
        if(slowRunner.next != fastRunner) {
            slowRunner.next = slowRunner.next.next;
        } else {
            slowRunner.next = null;
        }
        return head;
    }
	
}
