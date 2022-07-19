package com.leetcode.practice.trees.binarytrees;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class PathSumBTree {

	// My Solution all by myself: beats 100% of java soln in runtime and 94.56% of space time. Yaay!!!
	public boolean answer = false;
    public int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSumHelper(root, targetSum);
    }
    
    public boolean hasPathSumHelper(TreeNode root, int targetSum) {
        if(answer) return true;
        if(root.left == null && root.right == null) {
            sum += root.val;
            if(sum == targetSum) {
                answer = true;
                return true;
            } else {
                sum -= root.val;
                return false;
            }
        }
        sum += root.val;
        if(root.left != null) hasPathSum(root.left, targetSum);
        if(root.right != null) hasPathSum(root.right, targetSum);
        sum -= root.val;
        return answer;
    }
    
    // A very short solution
    public boolean hasPathSumShort(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
}
