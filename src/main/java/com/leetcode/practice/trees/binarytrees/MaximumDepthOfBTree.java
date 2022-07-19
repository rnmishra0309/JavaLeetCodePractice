package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class MaximumDepthOfBTree {
	
	public int answer = 0;
	
	// top-down approach
	public int getMaximumDepth(TreeNode root, int depth) {
		if(root == null) return answer;
		if(root.left == null && root.right == null) answer = Math.max(answer, depth);
		getMaximumDepth(root.left, depth+1);
		getMaximumDepth(root.right, depth+1);
		return answer;
	}
	
	// bottom-up approach
	public int getMaximumDepthBottomUp(TreeNode node) {
		if(node == null) return 0;
		int leftChildDepth = getMaximumDepthBottomUp(node.left);
		int rightChildDepth = getMaximumDepthBottomUp(node.right);
		return Math.max(leftChildDepth, rightChildDepth) + 1;
	}
}
