package com.leetcode.practice.linkedlist.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListNode {
	
	static final Logger logger = LogManager.getLogger(ListNode.class);
	
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode() {
		
	}
	
	public void printHead() {
		ListNode curr = this;
		StringBuilder result = new StringBuilder("");
		while(curr != null) {
			result.append(curr.val).append("-->");
			curr = curr.next;
		}
		result.append("NULL");
		logger.info(result.toString());
	}
}
