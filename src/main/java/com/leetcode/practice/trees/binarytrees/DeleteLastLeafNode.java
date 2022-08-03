package com.leetcode.practice.trees.binarytrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class DeleteLastLeafNode {
	
	static final Logger logger = LogManager.getLogger(DeleteLastLeafNode.class);
	
	public static boolean isLastNode = false;
	
	// recursive solution
	// this is wrong.
	public static TreeNode deleteLastNode(TreeNode root) {
		deleteLastNodeHelper(root);
		return root;
	}
	
	public static void deleteLastNodeHelper(TreeNode root) {
		if(root == null) return;
		if(root.right != null) {
			deleteLastNodeHelper(root.right);
		} else if(root.left != null) {
			deleteLastNodeHelper(root.left);
		} else {
			isLastNode = true;
			return;
		}
		if(isLastNode) {
			if(root.right != null) {
				root.right = null;
				isLastNode = false;
				return;
			} else if(root.left != null) {
				root.left = null;
				isLastNode = false;
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		
		InOrderTraversalOfBinaryTree obj = new InOrderTraversalOfBinaryTree();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(8);
		root.right.left = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		
		
		obj.iterativeInOrderUsingStack(root);
		
		root = deleteLastNode(root);
		
		logger.info("After deletion: ");
		obj.iterativeInOrderUsingStack(root);
	}
	
}
