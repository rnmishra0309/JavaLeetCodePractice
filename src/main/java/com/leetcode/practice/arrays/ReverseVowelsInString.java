package com.leetcode.practice.arrays;

import java.util.Stack;

public class ReverseVowelsInString {

    public String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if (vowels.contains(String.valueOf(s.charAt(i))))
                stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                sb.append(stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String reverseVowelsEfficient(String s) {

        boolean [] isVowel = new boolean[128];

        for(char c : "aoieuAOIEU".toCharArray()){
            isVowel[c] = true;
        }

        int p = 0;
        int p2 = s.length() - 1;

        char [] arr = s.toCharArray();
        while(p<p2){
            while(p<p2 && !isVowel[arr[p]])
                p++;
            while(p<p2 && !isVowel[arr[p2]])
                p2--;
            if(p<p2){
                char temp = arr[p];
                arr[p] = arr[p2];
                arr[p2] = temp;

                p2--;
                p++;
            }


        }

        return String.valueOf(arr);
    }

}
