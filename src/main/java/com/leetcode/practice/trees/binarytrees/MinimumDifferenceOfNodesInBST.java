package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

import java.util.*;

public class MinimumDifferenceOfNodesInBST {

    private final List<Integer> nodes = new ArrayList<>();

    public void inOrderTraversal(TreeNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        nodes.add(root.val);
        inOrderTraversal(root.right);
        return;
    }

    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        // ToDo: Write Your Code Here.
        inOrderTraversal(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            minDiff = Math.min(Math.abs((nodes.get(i) - nodes.get(i + 1))), minDiff);
        }
        return minDiff;
    }

}
