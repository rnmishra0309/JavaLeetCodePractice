package com.leetcode.practice.stack;

import java.util.Stack;

public class DailyTemperatures {

	// Implementation of Monotonic Decreasing Stack.
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] ret = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int idx = stack.pop();
				ret[idx] = i - idx;
			}
			stack.push(i);
		}
		return ret;
	}

}
