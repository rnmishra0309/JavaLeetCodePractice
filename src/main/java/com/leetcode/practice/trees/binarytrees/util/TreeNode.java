package com.leetcode.practice.trees.binarytrees.util;

public class TreeNode {
	public int val;
	public int id;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(int val, int id) {
		this.val = val;
		this.id = id;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int val, int id, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.id = id;
	}
}
