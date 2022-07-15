package com.leetcode.practice.linkedlist;

import com.leetcode.practice.linkedlist.util.ListNode;

public class MergeTwoSortedSingleLists {
	// Needed some help O(N) O(1)
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        } else if(list1 != null && list2 == null) {
            return list1;
        } else if(list2 != null && list1 == null) {
            return list2;
        }
        ListNode head = new ListNode();
        ListNode handler = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                handler.next = list1;
                list1 = list1.next;
            } else {
                handler.next = list2;
                list2 = list2.next;
            }
            handler = handler.next;
        }
         if (list1 != null) {
            handler.next = list1;
        } else if (list2 != null) {
            handler.next = list2;
        }
        return head.next;
    }
}
