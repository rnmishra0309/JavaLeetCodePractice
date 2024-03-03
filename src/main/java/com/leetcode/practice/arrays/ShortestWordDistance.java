package com.leetcode.practice.arrays;

import java.util.*;

/*

Problem Statement :- Given an array of strings words and two different strings
                     that already exist in the array word1 and word2,
                     return the shortest distance between these two words in the list.

Example 1:

Input: words = ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"], word1 = "fox", word2 = "dog"
Output: 5
Explanation: The distance between "fox" and "dog" is 5 words.

Example 2:

Input: words = ["a", "c", "d", "b", "a"], word1 = "a", word2 = "b"
Output: 1
Explanation: The shortest distance between "a" and "b" is 1 word

*/

public class ShortestWordDistance {

    public static void main(String[] args) {
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word1 = "the";
        String word2 = "dog";
        System.out.println(findShortestDistance(words, word1, word2));
    }

    private static int findShortestDistance(String[] words, String word1, String word2) {
        int diff = Integer.MAX_VALUE;
        int w1 = Integer.MAX_VALUE, w2 = Integer.MAX_VALUE;
        boolean foundWord = false; // to remove the cold start problem
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                w1 = i;
                foundWord = true;
            }
            else if (words[i].equals(word2)) {
                w2 = i;
                foundWord = true;
            }
            if(foundWord)
                diff = Math.min(diff, Math.abs(w1 - w2));
        }

        return diff;
    }

}
