package com.leetcode.practice.trees.binarytrees;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class ConvertPreOrderInOrderToBTree {
	
	static final Logger logger = LogManager.getLogger(ConvertPreOrderInOrderToBTree.class);
	
	public static TreeNode buildTree(Integer[] preorder, Integer[] inorder) {
        int length = inorder.length;
        return helper(preorder, inorder, 0, length-1, 0, length-1);
    }
    
    public static TreeNode helper(Integer[] preorder, Integer[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        if(preStart > preorder.length - 1 || inStart > inEnd) return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for(; rootIndex <= inEnd; rootIndex++) {
            if(inorder[rootIndex] != null && inorder[rootIndex] == rootValue) break;
        }
        int leftSubTreeSize = rootIndex - inStart;
        int rightSubTreeSize = inEnd - rootIndex;
        root.left = helper(preorder, inorder, inStart, rootIndex-1, preStart+1, preStart+leftSubTreeSize);
        root.right = helper(preorder, inorder, rootIndex+1, inEnd, preEnd-rightSubTreeSize+1, preEnd);
        return root;
    }
    
    public static void main(String[] args) {
        Integer[] preorder = {3,9,20,15,7};
        Integer[] inorder = {9,3,15,20,7};
    	TreeNode root = buildTree(preorder, inorder);
    	logger.info(root);
    }
}
