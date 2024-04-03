package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class CheckIfBalancedBinaryTree {

    public static int findDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = 1 + findDepth(root.left);
        int rightDepth = 1 + findDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return (Math.abs(leftDepth - rightDepth) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isBalanced(root));
    }

}
