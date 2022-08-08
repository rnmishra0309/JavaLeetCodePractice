package com.leetcode.practice.stack;

import java.util.Stack;

/**
 * find the next greater element of every element in an array

 * arr[] = {5, 9, 1, 12, 14, 6}
 * o/p[] = 5 -> 9
 *         9 -> 12
 *         1 -> 12
 *         12 -> 14
 *         14 -> -1
 *         6 -> -1
 * @author RudraNM
 *
 * stack = [5,9
 */

public class FindNextGreaterElementInArray {
	
	/* if stack is not empty, then
    pop an element from stack.
    If the popped element is smaller
    than next, then
    a) print the pair
    b) keep popping while elements are
    smaller and stack is not empty */
	public static void findNextGreaterElement(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] output = new int[input.length];
		for(int i = input.length - 1; i >=0 ; i--) {
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && stack.peek() <= input[i]) {
					stack.pop();
				}
			}
			output[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(input[i]);
		}
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i] + " -> " + output[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] input = {5, 9, 1, 12, 14, 6};
		findNextGreaterElement(input);
	}
}
