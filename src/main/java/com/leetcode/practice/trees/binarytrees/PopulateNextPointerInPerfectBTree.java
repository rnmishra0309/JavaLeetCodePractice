package com.leetcode.practice.trees.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class PopulateNextPointerInPerfectBTree {
	public TreeNode connect(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null && queue.isEmpty()) return root;
            else if(curr == null) {
                queue.add(null);
                continue;
            } else {
                curr.next = queue.peek();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }
}
