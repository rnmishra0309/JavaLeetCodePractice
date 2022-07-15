package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class AddTwoNumbersInLL {
	
	// my solution with half way correct and other half from discussion.
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
	
	// less runtime more optimal solution
	public ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode p = l1;
        ListNode prev = p;

        while (p != null) {
            int sum  = tmp + p.val + (l2 == null ? 0: l2.val);
            tmp = sum / 10;
            p.val = sum % 10;
            prev = p;
            p = p.next;
            if (p == null && l2 != null) {
                prev.next = l2.next;
                p = l2.next;
                l2 = null;
            }
            if (l2 != null) l2 = l2.next;
        }
        if (tmp != 0) prev.next = new ListNode(tmp);
        return l1;
    }
}
