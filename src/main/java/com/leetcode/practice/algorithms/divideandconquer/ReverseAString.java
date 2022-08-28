package com.leetcode.practice.algorithms.divideandconquer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseAString {
	
	static final Logger logger = LogManager.getLogger(ReverseAString.class);
	
	public static String reverseUsingInBuilt(String str) {
		StringBuilder strBuilder = new StringBuilder(str);
		return strBuilder.reverse().toString();
	}
	
	public static String reverseIteratively(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder result = new StringBuilder();
		for(int i = charArray.length - 1; i >= 0; i--) {
			result.append(charArray[i]);
		}
		return result.toString();
	}
	
	public static String reverseiterativeDivideAndConquer(String str) {
		char[] charArray = str.toCharArray();
		int start = 0;
		int end = charArray.length - 1;
		while(start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		return new String(charArray);
	}
	
	public static String reverseRecursiveDivideAndConquer(String str) {
		char[] charArray = str.toCharArray();
		reverseHelper(charArray, 0, charArray.length - 1);
		return new String(charArray);
	}
	
	public static void reverseHelper(char[] charArray, int start, int end) {
		if(start > end) return;
		char temp = charArray[start];
		charArray[start] = charArray[end];
		charArray[end] = temp;
		reverseHelper(charArray, ++start, --end);
		return;
	}
	
	public static void main(String[] args) {
		String str = "Reverse A String";
		logger.info(reverseUsingInBuilt(str));
		logger.info(reverseIteratively(str));
		logger.info(reverseiterativeDivideAndConquer(str));
		logger.info(reverseRecursiveDivideAndConquer(str));
	}
	
}
