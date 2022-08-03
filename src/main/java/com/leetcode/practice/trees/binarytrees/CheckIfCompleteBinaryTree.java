package com.leetcode.practice.trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class CheckIfCompleteBinaryTree {
	
	// iterative solution - 1
	public static boolean checkCompleteBTreeITOne(TreeNode root) {
		if(root == null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean notFullNode = false;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr.left != null) {
				if(notFullNode == true) return false;
				queue.add(curr.left);
			} else {
				notFullNode = true;
			}
			if(curr.right != null) {
				if(notFullNode == true) return false;
				queue.add(curr.right);
			} else {
				notFullNode = true;
			}
		}
		return true;
	}
	
	// iterative solution - 2
	public static boolean checkCompleteBTreeITTwo(TreeNode root) {
		if(root == null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean notFullNode = false;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr == null) {
				notFullNode = true;
			} else {
				if(notFullNode) return false;
				queue.add(curr.left);
				queue.add(curr.right);
			}
		}
		return true;
	}
	
	// recursive solution
	/**
	 * 1. Calculate the number of nodes (count) in the binary tree.
	 * 2. Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0
	 *    and the number of nodes in the binary (count).
	 * 3. If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
	 * 4. If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count)
	 *    i.e. (i>= count), then the tree is not a complete binary. Return false.
	 * 5. Recursively check the left and right sub-trees of the binary tree for same condition.
	 *    For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
	 */
	public static boolean checkCompleteBTreeRecursive(TreeNode root) {
		boolean result = false;
		int index = 0;
		int totalNodes = getCountOfNodes(root);
		result = isCompletedBTree(root, index, totalNodes);
		return result;
	}
	
	public static int getCountOfNodes(TreeNode root) {
		if(root == null) return 0;
		return (1 + getCountOfNodes(root.left) + getCountOfNodes(root.right));
	}
	
	public static boolean isCompletedBTree(TreeNode root, int index, int totalNodes) {
		if(root == null) return true;
		if(index >= totalNodes) return false;
		return (isCompletedBTree(root.left, 2 * index + 1, totalNodes)
				&& isCompletedBTree(root.right, 2 * index + 2, totalNodes));
	}
}
