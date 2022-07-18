package com.leetcode.practice.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.stack.util.MinStack;

public class MinStackMain {
static final Logger logger = LogManager.getLogger(MinStackMain.class);
	
	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(2147483646);
		s.push(2147483646);
		s.push(2147483647);
		s.top();
		s.pop();
		s.getMin();
		s.pop();
		s.getMin();
		s.pop();
		s.push(2147483647);
		s.top();
		s.getMin();
		s.push(-2147483648);
		s.top();
		s.getMin();
		s.pop();
		s.getMin();
	}
}
