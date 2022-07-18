package com.leetcode.practice.stack;

import java.util.Stack;

public class EvaluatePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token: tokens) {
                if(token.equals("+")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(first + second);
                } else if(token.equals("-")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second - first);
                } else if(token.equals("*")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(first * second);
                } else if(token.equals("/")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    if(first > second) stack.push(second / first);
                    else stack.push(second / first);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.peek();
        }
}
