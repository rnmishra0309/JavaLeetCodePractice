package com.leetcode.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.practice.linkedlist.util.ListNode;

public class FindIfTwoLinkedListIntersect {
	
	// Naive solutions using hashset. TC: O(M+N), SC: O(N+M)
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        if(headA.next == headB || headB.next == headA || headA == headB) {
            return currentNodeA;
        }
        while((currentNodeA!=null && currentNodeA.next != null) || (currentNodeB!=null && currentNodeB.next != null)) {
            if(nodeSet.contains(currentNodeA)) {
                return currentNodeA;
            } else if (nodeSet.contains(currentNodeB)) {
                return currentNodeB;
            } else if(currentNodeA == currentNodeB) {
                return currentNodeA;
            } else {
                if(currentNodeA != null) {
                    nodeSet.add(currentNodeA);
                    currentNodeA = currentNodeA.next;
                }
                if(currentNodeB != null) {
                    nodeSet.add(currentNodeB);
                    currentNodeB = currentNodeB.next;
                }
            }
        }
        return null;
    }
	
	// Naive approach - 2 Comparing last Nodes
	public boolean isListIntersecting(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
            return false;
        }
		ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        while(currentNodeA.next != null) {
        	currentNodeA = currentNodeA.next;
        }
        
        while(currentNodeB.next != null) {
        	currentNodeB = currentNodeB.next;
        }
        
        if(currentNodeA == currentNodeB) {
        	return true;
        }
        return false;
	}
	
	// efficient solution from CCI Book. Coded Myself After Hints
	// Runtime beats 99.96%, space time beats 41.46%
	// O(M+N) TC, O(1) SC
	public ListNode getIntersectionNodeEfficient(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        int lengthA = 0, lengthB = 0, difference = 0;
        while(currentNodeA.next != null) {
            lengthA++;
            currentNodeA = currentNodeA.next;
        }
        currentNodeA = headA;
        while(currentNodeB.next != null) {
            lengthB++;
            currentNodeB = currentNodeB.next;
        }
        currentNodeB = headB;
        if(lengthA > lengthB) {
            difference = lengthA - lengthB;
            while(difference-- != 0) {
                currentNodeA = currentNodeA.next;
            }
        } else {
            difference = lengthB - lengthA;
            while(difference-- != 0) {
                currentNodeB = currentNodeB.next;
            }
        }
        while(currentNodeA != currentNodeB) {
            currentNodeA = currentNodeA.next;
            currentNodeB = currentNodeB.next;
        }
        if(currentNodeA == currentNodeB) {
            return currentNodeA;
        }
        return null;
    }
}
