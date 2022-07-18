package com.leetcode.practice.stack.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinStack {
	
	static final Logger logger = LogManager.getLogger(MinStack.class);
	
	private class Node {
		public int value;
		public int minimum;
		public Node next;
		public Node (int val, int min, Node next) {
			this.value = val;
			this.minimum = min;
			this.next = next;
		}
	}
	
	private Node head;
	
	public void push(int val) {
		if(head == null) head = new Node(val, val, null);
		else head = new Node(val, Math.min(val, head.minimum), head);
	}
	
	public void pop() {
		head = head.next;
	}
	
	public int getMin() {
		logger.info(head.minimum);
		return head.minimum;
	}
	
	public int top() {
		logger.info(head.value);
		return head.value;
	}
}
