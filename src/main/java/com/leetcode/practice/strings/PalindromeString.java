package com.leetcode.practice.strings;

import java.util.*;

public class PalindromeString {

    public static boolean isPalindrome(String s) {
        List<Character> charList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i))) {
                charList.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        int start = 0, end = charList.size() - 1;
        while(start >= 0 && end >= 0 && start <= end) {
            if(charList.get(start) != charList.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindromeEfficientInRealTime(String s) {
        int low = 0, high = s.length()-1;
        while(low <= high){
            char x = s.charAt(low);
            if(x >= 'A' && x <= 'Z')
                x += 32;

            char y = s.charAt(high);
            if(y >= 'A' && y <= 'Z')
                y += 32;
            // System.out.println(x+" - "+y);

            if(!((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9')) ){
                low++;
                continue;
            }
            if(!((y >= 'a' && y <= 'z') || (y >= '0' && y <= '9'))){
                high--;
                continue;
            }
            if(x != y)
                return false;
            high--;
            low++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

}
