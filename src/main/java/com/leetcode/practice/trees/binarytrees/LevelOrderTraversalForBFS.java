package com.leetcode.practice.trees.binarytrees;

import java.util.*;
import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class LevelOrderTraversalForBFS {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return result;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> sublist = new ArrayList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				sublist.add(queue.poll().val);
			}
			result.add(sublist);
		}
		return result;
	}

}
