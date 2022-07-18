package com.leetcode.practice.stack.util;

import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayStack {
	
	static final Logger logger = LogManager.getLogger(ArrayStack.class);
	
	private List<Integer> stack;
	
	public ArrayStack() {
		stack = new ArrayList<Integer>();
	}
	
	public boolean push(int value) {
		stack.add(value);
		return true;
	}
	
	public boolean pop() {
		if(isEmpty()) return false;
		stack.remove(stack.size() - 1);
		return true;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
}
