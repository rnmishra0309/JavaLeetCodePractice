package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class LowestCommonAncestor {
	public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) return root;
		TreeNode left = findLCA(root.left, p, q);
		TreeNode right = findLCA(root.right, p, q);
		if(left == null && right == null) return null;
		else if(left == null && right != null) return right;
		else if(left != null && right == null) return left;
		return root;
	}
}
