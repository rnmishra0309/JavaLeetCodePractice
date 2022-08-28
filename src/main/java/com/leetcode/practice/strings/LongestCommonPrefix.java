package com.leetcode.practice.strings;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] arr) {
		if(arr.length == 0 || arr[0].length() == 0) return "";
		for(int i=0; i < arr[0].length(); i++) {
			char c = arr[0].charAt(i);
			for(int j=1; j<arr.length; j++) {
				if(i == arr[j].length() || arr[j].charAt(i) != c) {
					return arr[0].substring(0, i);
				}
			}
		}
		return arr[0];
	}
}
