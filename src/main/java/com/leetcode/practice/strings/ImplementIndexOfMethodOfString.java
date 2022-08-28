package com.leetcode.practice.strings;

public class ImplementIndexOfMethodOfString {
	// My Solution
	// input: haystack = "hello", needle = "ll"
	// output: 2 just like haystack.indexOf(needle);
	public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        else {
            int i = 0;
            while(i <= haystack.length() - needle.length()) {
                if(haystack.charAt(i) == needle.charAt(0)) {
                    if(haystack.substring(i,i+needle.length()).equals(needle)) {
                        return i;
                    }
                }
                i++;
            }
            return -1; 
        }
    }
	
}
