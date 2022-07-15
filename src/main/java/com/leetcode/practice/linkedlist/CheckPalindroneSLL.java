package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class CheckPalindroneSLL {
	// iterative approach (O(N), O(1))
	public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode hi = reverse(slow);
        ListNode lo = head;
        while(lo.next != null) {
            if(lo.val != hi.val) return false;
            lo = lo.next;
            hi = hi.next;
        }
        return true;
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
