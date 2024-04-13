package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class KthSmallestNodeInBST {

    // `count` keeps track of the number of nodes we've traversed in-order.
    private int count = 0;

    // `result` will hold our final answer.
    private int result = 0;


    // This method is the public API that finds the kth smallest element in a BST.
    public int kthSmallest(TreeNode root, int k) {
        // Start the in-order traversal.
        traverse(root, k);

        // Once traversal is done, the `result` will hold our answer.
        return result;
    }

    // A recursive function to do an in-order traversal of the BST.
    // We stop traversing once we've visited `k` nodes.
    private void traverse(TreeNode node, int k) {
        // If the current node is null or we've already traversed k nodes, return.
        if (node == null || count >= k)
            return;

        // First, traverse the left subtree.
        traverse(node.left, k);

        // Increment the counter for the current node.
        count++;

        // If we've traversed exactly k nodes, this is our result.
        if (count == k)
            result = node.val;

        // Finally, traverse the right subtree.
        traverse(node.right, k);
    }

}
