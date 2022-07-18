package com.leetcode.practice.trees.binarytrees;

import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class InOrderTraversalOfBinaryTree {

	static final Logger logger = LogManager.getLogger(InOrderTraversalOfBinaryTree.class);

	// Recursive approach
	public void recursiveInOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		recursiveInOrderTraversal(node.left);
		logger.info(node.val);
		recursiveInOrderTraversal(node.right);
		return;
	}

	// Iterative approach Using stack
	public void iterativeInOrderUsingStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			logger.info(curr.val);
			curr = curr.right;
		}
		return;
	}

	// Morris Traversal - Iterative and without using stack
	/**
	 * Step 1: Initialize current as root
	 * 
	 * Step 2: While current is not NULL,
	 * 
	 * If current does not have left child
	 * 
	 * a. Add current’s value
	 * 
	 * b. Go to the right, i.e., current = current.right
	 * 
	 * Else
	 * 
	 * a. In current's left subtree, make current the right child of the rightmost
	 * node
	 * 
	 * b. Go to this left child, i.e., current = current.left
	 * 
	 * @param root
	 */
	public void morrisTraversal(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				logger.info(curr.val);
				curr = curr.right;
			} else {
				TreeNode prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr;
				TreeNode temp = curr;
				curr = curr.left;
				temp.left = null;
			}
		}
		return;
	}
}
