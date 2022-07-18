package com.leetcode.practice.trees.binarytrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class PostOrderTraversalOfBinaryTree {

	static final Logger logger = LogManager.getLogger(PostOrderTraversalOfBinaryTree.class);

	// Recursive Solution
	public void recursivePostOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		recursivePostOrderTraversal(node.left);
		recursivePostOrderTraversal(node.right);
		logger.info(node.val);
		return;
	}
}
