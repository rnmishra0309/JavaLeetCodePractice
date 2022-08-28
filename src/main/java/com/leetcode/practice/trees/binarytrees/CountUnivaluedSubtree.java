package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class CountUnivaluedSubtree {
	
	// My Solution
	
	public static int count = 0;

	public static int countUnivalueSubTree(TreeNode root) {
		if (root == null)
			return 0;
		countUnivaluedSubTreeHelper(root);
		return count;
	}

	public static boolean isLeafNode(TreeNode root) {
		if(root == null) return false;
		return (root.left == null && root.right == null);
	}

	public static void countUnivaluedSubTreeHelper(TreeNode root) {
		if (root == null) return;
		if (isLeafNode(root)) {
			count++;
			return;
		}
		if ((root.left != null && root.val == root.left.val && isLeafNode(root.left))
				|| (root.right != null && root.val == root.right.val && isLeafNode(root.right))) {
			count++;
			countUnivaluedSubTreeHelper(root.left);
			countUnivaluedSubTreeHelper(root.right);
			return;
		}
		countUnivaluedSubTreeHelper(root.left);
		countUnivaluedSubTreeHelper(root.right);
		return;
	}
	
	// Somewhat efficient - https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
	public static int callIsUnivaluedSubTree(TreeNode root) {
		if(root == null) return 0;
		isUnivaluedSubTree(root);
		return count;
	}
	public static boolean isUnivaluedSubTree(TreeNode root) {
		if(root.left == null && root.right == null) {
			count++;
			return true;
		}
		boolean isUnivalued = true;
		if(root.left != null) {
			isUnivalued = isUnivaluedSubTree(root.left) && isUnivalued && root.val == root.left.val;
		}
		if(root.right != null) {
			isUnivalued = isUnivaluedSubTree(root.right) && isUnivalued && root.val == root.right.val;
		}
		if(!isUnivalued) return false;
		count++;
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		System.out.println(countUnivalueSubTree(root));
	}

}
