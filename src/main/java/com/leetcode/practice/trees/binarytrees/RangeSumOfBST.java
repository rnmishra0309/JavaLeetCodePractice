package com.leetcode.practice.trees.binarytrees;

import java.util.*;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

import static com.leetcode.practice.trees.binarytrees.ConvertPreOrderInOrderToBTree.buildTree;
import static com.leetcode.practice.trees.binarytrees.LevelOrderTraversalForBFS.levelOrder;

public class RangeSumOfBST {

    private static final List<Integer> inOrder = new ArrayList<>();

    public static void inOrderTraversal(TreeNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        inOrder.add(root.val);
        inOrderTraversal(root.right);
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        inOrderTraversal(root);
        for (Integer integer : inOrder) {
            if (integer >= L && integer <= R) {
                sum += integer;
            }
        }
        return sum;
    }

    public int rangeSumBSTEfficient(TreeNode root, int L, int R) {
        if (root == null) return 0;  // Base case

        // If the current node's value is out of the range on the higher side
        if (root.val > R) return rangeSumBST(root.left, L, R);

        // If the current node's value is out of the range on the lower side
        if (root.val < L) return rangeSumBST(root.right, L, R);

        // Current node's value is in the range, include it and check both children
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

}
