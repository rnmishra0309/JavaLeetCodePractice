package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class ConvertInOrderPostOrderToBTree {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        TreeNode root = helper(inorder, postorder, 0, length-1, 0, length-1);
        return root;
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd) {
        if(inStart > inEnd) return null;
        int rootValue = postorder[poEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for(; rootIndex <= inEnd; rootIndex++) {
            if(inorder[rootIndex] == rootValue) break;
        }
        int leftSubTreeSize = rootIndex - inStart;
        int rightSubTreeSize = inEnd - rootIndex;
        root.left = helper(inorder, postorder, inStart, rootIndex - 1, poStart, poStart + leftSubTreeSize - 1);
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, poEnd - rightSubTreeSize, poEnd - 1);
        return root;
    }
	
}
