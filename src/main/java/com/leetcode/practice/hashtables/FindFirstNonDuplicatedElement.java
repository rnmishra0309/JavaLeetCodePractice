package com.leetcode.practice.hashtables;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonDuplicatedElement {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) map.put(arr[i], -1);
            else map.put(arr[i], i);
        }
        for(char ch: map.keySet()) {
            if(map.get(ch) != -1) return map.get(ch);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abcabd"));
    }

}
