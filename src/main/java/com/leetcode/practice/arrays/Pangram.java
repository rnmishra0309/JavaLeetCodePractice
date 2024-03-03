package com.leetcode.practice.arrays;

import java.util.*;

public class Pangram {

    public static void main(String[] args) {
        String sentence = "         th    eq     uickbro     wnfox      jump      sov      erthelazydog   ";
        System.out.println(checkIfPangramEfficient(sentence));
    }

    private static boolean checkIfPangram(String sentence) {
        String sentenceWithoutSpaces = sentence.replaceAll("\\s", "");
        System.out.println("sentence:"+sentenceWithoutSpaces);
        char[] characters = sentenceWithoutSpaces.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(char ch: characters) charSet.add(ch);
        return charSet.size() == 26;
    }

    private static boolean checkIfPangramEfficient(String sentence) {
        String sentenceWithoutSpaces = sentence.replaceAll("\\s", "");
        char start = 'a';
        int j = 0;
        while(j < 26) {
            if(sentenceWithoutSpaces.contains(String.valueOf(start)))
                start++;
            else return false;
            j++;
        }
        return true;
    }

}
