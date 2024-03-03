package com.leetcode.practice.strings;

import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "ANAGRAM";
        String t = "NAGARRRRRRAM";

        System.out.println(isValidAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) { // O(N) && O(26)
        int[] countOfChar = new int[26];

        for (char c : s.toCharArray()){
            countOfChar[c - 'a']++;
        }

        for (char c : t.toCharArray()){
            countOfChar[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(countOfChar[i] != 0)
                return false;
        }

        return true;
    }

    private static boolean isValidAnagram(String s, String t) { // O(N) && O(N) -> Inefficient
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()) {
            map.put(ch, (map.getOrDefault(ch, 0) + 1));
        }

        for(char ch: t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, (map.get(ch) - 1));
            } else {
                return false;
            }
        }

        for(char ch: map.keySet()) {
            if(map.get(ch) != 0) {
                return false;
            }
        }

        return true;
    }

}
