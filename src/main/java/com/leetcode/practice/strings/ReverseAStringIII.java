package com.leetcode.practice.strings;

public class ReverseAStringIII {
	
	public String reverseWords(String s) {
        StringBuilder result = new StringBuilder(s.strip().trim());
        result.reverse();
        String[] wordsArray = result.toString().split(" ");
        result.setLength(0);
        for(int i = wordsArray.length - 1; i >= 0; i--) {
            result.append(wordsArray[i]).append(" ");
        }
        return result.toString().trim();
    }
	
}
