package com.leetcode.practice.trees.binarytrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

import java.util.*;

public class SymmetricTree {

	static final Logger logger = LogManager.getLogger(SymmetricTree.class);
	
	public static Queue<TreeNode> queue = new LinkedList<TreeNode>();

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

		logger.info(isSymmetricRecursive(root));
		logger.info(isSymmetricIterative(root));
	}
}
