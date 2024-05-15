package com.leetcode.practice.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> fmap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        for(char alphabet: s.toCharArray())
            fmap.put(alphabet, fmap.getOrDefault(alphabet, 0) + 1);
        maxHeap.addAll(fmap.entrySet());
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            result.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("apple"));
    }

}
