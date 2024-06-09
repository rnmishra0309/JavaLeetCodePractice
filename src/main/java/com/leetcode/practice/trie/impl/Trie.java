package com.leetcode.practice.trie.impl;

import java.util.Arrays;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode currentNode = root;
        int index;
        for(char ch: word.toCharArray()) {
            index = ch - 'a';
            if(!currentNode.hasChild(index)) {
                currentNode.setChildAtIndex(index);
            }
            currentNode = currentNode.getChild(index);
        }
        currentNode.setEndOfWord(true);
    }

    public boolean ifWordExists(String word) {
        TrieNode currentNode = root;
        int index;
        for(char ch: word.toCharArray()) {
            index = ch - 'a';
            if(!currentNode.hasChild(index))
                return false;
            currentNode = currentNode.getChild(index);
        }
        return currentNode.isWord();
    }

    private boolean delete(TrieNode node, String word, int index) { // try this again
        if(index == word.length()) {
            if (node.isWord()) {
                node.setEndOfWord(false);
            }
            return !node.hasAnyChild();
        }
        int childIndex = word.charAt(index) - 'a';
        boolean shouldDelete = delete(node.getChild(childIndex), word, ++index);
        if(shouldDelete) {
            node.deleteChild(childIndex);
            return !node.hasAnyChild();
        }
        return true;
    }

    public boolean deleteWord(String word) {
        return delete(root, word, 0);
    }

}
