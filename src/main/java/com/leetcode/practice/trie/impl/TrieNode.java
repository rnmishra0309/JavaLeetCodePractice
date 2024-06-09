package com.leetcode.practice.trie.impl;

public class TrieNode {

    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        for(int i=0; i<26; i++) children[i] = null;
    }

    public boolean hasAnyChild() {
        for(int i=0; i<26; i++) {
            if(this.children[i] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasChild(int index) {
        return (this.children[index] != null);
    }

    public boolean isWord() {
        return this.isEndOfWord;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public TrieNode getChild(Integer index) {
        return children[index];
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public void setChildAtIndex(int index) {
        children[index] = new TrieNode();
    }

    public void deleteChild(int index) {
        children[index] = null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        char ch;
        str.append("TRIE-NODE{");
        for(int i=0; i<this.children.length; i++) {
            if(this.children[i] != null) {
                ch = (char) (i + 'a');
                str.append((i == 0 ? "[" : "")).append(ch).append("->").append(this.children[i].toString());
            }
        }
        return str.toString();
    }
}
