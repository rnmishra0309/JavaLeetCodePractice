package com.leetcode.practice.strings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReverseWordsInString {
	
	static final Logger logger = LogManager.getLogger(ReverseWordsInString.class);
	
	public static String reverseWords(String s) {
		String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            if (!words[i].isEmpty())
                result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }
	
	public static void main(String[] args) {
		logger.info(reverseWords("Hello      World My     Name               is Rudra"));
	}
	
}
