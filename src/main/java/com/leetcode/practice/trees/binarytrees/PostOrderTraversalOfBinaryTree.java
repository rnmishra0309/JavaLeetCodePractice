package com.leetcode.practice.trees.binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
	
	// Iterative post order traversal using stack
	public List<Integer> iterativePostOrderTraversalUsingStack(TreeNode node) {
		if(node == null) return null;
		LinkedList<Integer> result = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			result.addFirst(currNode.val);
			if(currNode.left != null) {
				stack.push(currNode.left);
			}
			if(currNode.right != null) {
				stack.push(currNode.right);
			}
		}
		return result;
	}
}
