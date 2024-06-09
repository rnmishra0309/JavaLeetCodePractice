package com.leetcode.practice.trie;

import com.leetcode.practice.trie.impl.Trie;

import java.util.*;

public class IndexOfPairsOfStrings {

    public Trie trie = new Trie();

    public List<List<Integer>> indexPairs(String text, List<String> words) {
        List<List<Integer>> result = new ArrayList<>();
        words.forEach(trie::insertWord);

        return result; // Return a list of lists containing index pairs
    }

}
