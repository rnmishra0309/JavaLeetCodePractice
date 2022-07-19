package com.leetcode.practice.trees.binarytrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

import java.util.*;

public class SymmetricTree {

	static final Logger logger = LogManager.getLogger(SymmetricTree.class);

	// My Solution: It has some issues but good idea though.
	/**
	 * 1. Do pre-order traversal in the root.left and push the elements into the
	 * stack; 2. Do post-order traversal in the root.right and pop from the stack
	 * and compare; 3. if stack is empty then it is mirror else not.
	 */
	public static Stack<TreeNode> stack = new Stack<TreeNode>();
	public static Queue<TreeNode> queue = new LinkedList<TreeNode>();

	public static void putInStackUsingPreOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		stack.push(node);
		putInStackUsingPreOrderTraversal(node.left);
		putInStackUsingPreOrderTraversal(node.right);
		return;
	}

	public static void checkFromStackUsingPostOrderTraversal(TreeNode node) {
		if (node == null)
			return;
		checkFromStackUsingPostOrderTraversal(node.left);
		checkFromStackUsingPostOrderTraversal(node.right);
		if (node.id == stack.peek().id)
			stack.pop();
		return;
	}

	public static boolean isSymmetric(TreeNode root) {
		putInStackUsingPreOrderTraversal(root.left);
		checkFromStackUsingPostOrderTraversal(root.right);
		return stack.isEmpty();
	}

	// Recursive solution
	public static boolean isSymmetricRecursive(TreeNode root) {
		return root == null || isSymmetricHelper(root.left, root.right);
	}

	private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}

	// Iterative Solution Using Queue
	public static boolean isSymmetricIterative(TreeNode root) {
		if (root == null)
			return true;
		queue.add(root.left);
		queue.add(root.right);
		while (queue.size() > 1) {
			TreeNode left = queue.poll(), right = queue.poll();
			if (left == null && right == null)
				continue;
			if (left == null ^ right == null)
				return false;
			if (left.val != right.val)
				return false;
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, 0);
		root.left = new TreeNode(2, 1);
		root.right = new TreeNode(2, 1);
		root.left.left = new TreeNode(3, 2);
		root.left.right = new TreeNode(4, 3);
		root.right.left = new TreeNode(4, 3);
		root.right.right = new TreeNode(3, 2);

		logger.info(isSymmetric(root));
		logger.info(isSymmetricRecursive(root));
		logger.info(isSymmetricIterative(root));
	}
}
