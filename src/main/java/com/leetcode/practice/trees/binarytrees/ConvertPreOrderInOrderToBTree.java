package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class ConvertPreOrderInOrderToBTree {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        TreeNode root = helper(preorder, inorder, 0, length-1, 0, length-1);
        return root;
    }
    
    public static TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        if(preStart > preorder.length - 1 || inStart > inEnd) return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for(; rootIndex <= inEnd; rootIndex++) {
            if(inorder[rootIndex] == rootValue) break;
        }
        int leftSubTreeSize = rootIndex - inStart;
        int rightSubTreeSize = inEnd - rootIndex;
        root.left = helper(preorder, inorder, inStart, rootIndex-1, preStart+1, preStart+leftSubTreeSize);
        root.right = helper(preorder, inorder, rootIndex+1, inEnd, preEnd-rightSubTreeSize+1, preEnd);
        return root;
    }
    
    public static void main(String[] args) {
    	int[] preorder = {3,9,20,15,7};
    	int[] inorder = {9,3,15,20,7};
    	TreeNode root = buildTree(preorder, inorder);
    }
}
