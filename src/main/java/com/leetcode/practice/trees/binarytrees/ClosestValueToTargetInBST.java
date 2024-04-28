package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class ClosestValueToTargetInBST {

    public Integer result;
    public Double diff = Double.MAX_VALUE;

    public void inOrder(TreeNode root, double target) {
        if(root == null) return;
        inOrder(root.left, target);
        if(diff > Math.abs((root.val - target))) {
            diff = Math.abs((root.val - target));
            result = root.val;
        }
        inOrder(root.right, target);
    }

    // This function finds the value in the BST closest to the target.
    public int closestValue(TreeNode root, double target) { // O(N)
        inOrder(root, target);
        return result;
    }

    // This function finds the value in the BST closest to the target.
    public int closestValueEfficient(TreeNode root, double target) { // O(logN)

        // Initialize the closest value to the root's value.
        // This acts as a running minimum difference tracker.
        int closestVal = root.val;

        // Traverse the tree starting from the root.
        while (root != null) {

            // Check if the current node's value is closer to the target than the previous closest value.
            // If so, update closestVal.
            if (Math.abs(target - root.val) < Math.abs(target - closestVal)) {
                closestVal = root.val;
            }

            // Decide the direction to traverse.
            // If the target is less than the current node's value, we move left; otherwise, move right.
            // This decision is made based on the properties of a BST.
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // Once we've traversed all possible paths, return the closest value.
        return closestVal;
    }

}
