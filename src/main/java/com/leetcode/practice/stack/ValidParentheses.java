package com.leetcode.practice.stack;

import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidParentheses {
	
	static final Logger logger = LogManager.getLogger(ValidParentheses.class);
	
	private static Stack<Character> stack = new Stack<Character>();
	
	// O(N) TC O(1) SC
	public static boolean isValidString(String s) {
		if(s.length() % 2 != 0) return false;
		for(char ch: s.toCharArray()) {
			if(ch == '(') stack.push(')');
			else if (ch == '[') stack.push(']');
			else if (ch == '{') stack.push('}');
			else if (stack.isEmpty() || stack.pop() != ch) return false;
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		
	}
}
