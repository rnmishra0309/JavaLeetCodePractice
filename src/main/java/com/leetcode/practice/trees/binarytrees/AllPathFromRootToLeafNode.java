package com.leetcode.practice.trees.binarytrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class AllPathFromRootToLeafNode {
	
	static final Logger logger = LogManager.getLogger(AllPathFromRootToLeafNode.class);
	
	public static boolean printAllPaths(TreeNode node, StringBuilder path) {
		if(node == null) return false;
		path.append(node.val);
		if(node.left == null && node.right == null) {
			logger.info(path.toString());
			return true;
		}
		boolean leftSide = printAllPaths(node.left, path);
		if(leftSide) path.deleteCharAt(path.length() - 1);
		boolean rightSide = printAllPaths(node.right, path);
		if(rightSide) path.deleteCharAt(path.length() - 1);
		return true;
	}
	
	public static void main(String[] args) {
		/*
		 * 
		 *      1
		 *     /  \
		 *   2     3
		 *  /     / \
		 * 4     5   6
		 *      / \
		 *     7   8
		 *      \
		 *       9
		 * 
		 */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.left.left.right = new TreeNode(9);
		root.right.right = new TreeNode(6);
		printAllPaths(root, new StringBuilder());
	}
	
}
