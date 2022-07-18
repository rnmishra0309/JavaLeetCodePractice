package com.leetcode.practice.trees.binarytrees;

import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class PreOrderTraversalOfBinaryTree {

	static final Logger logger = LogManager.getLogger(PreOrderTraversalOfBinaryTree.class);

	// Recursive Solution
	public void recursivePreOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		logger.info(node.val);
		recursivePreOrderTraversal(node.left);
		recursivePreOrderTraversal(node.right);
		return;
	}

	// Iterative solution using Stack
	public void iterativePreOrderUsingStack(TreeNode node) {
		if (node == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			logger.info(currNode.val);
			if (currNode.right != null)
				stack.push(currNode.right);
			if (currNode.left != null)
				stack.push(currNode.left);
		}
	}

	// Iterative approach by Not Using Stack i.e Morris Traversal
	public void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				logger.info(cur.val);
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;
				if (prev.right == null) {
					logger.info(cur.val);
					prev.right = cur;
					cur = cur.left;
				} else {
					prev.right = null;
					cur = cur.right;
				}
			}
		}
		return;
	}

}
