package com.leetcode.practice.trees.binarytrees;

/*
    Given two binary trees, root1 and root2, merge them into a single, new binary tree.

    If two nodes from the given trees share the same position,
    their values should be summed up in the resulting tree.
    If a node exists in one tree but not in the other, the resulting tree should have a node at the same position
    with the value from the existing node.

    Examples

    Example 1:

    Trees:

    Tree 1:       1            Tree 2:       1
                /   \                      /   \
               3     2                    2     3

    Merged:       2
                /   \
                5    5

    Justification: The root nodes of both trees have the value 1,
    so the merged tree's root has a value of 1 + 1 = 2.
    For the left child, 3 + 2 = 5 and for the right child, 2 + 3 = 5.



    Example 2:

    Trees:

    Tree 1:      5            Tree 2:       3
               /   \                      /   \
              4     7                    2     6

    Merged:       8
                /   \
               6    13
    Justification: The root nodes have values 5 and 3 respectively.
     So, the merged tree's root value becomes 5 + 3 = 8. The left child is 4 + 2 = 6 and the right child is 7 + 6 = 13.


     Example 3:

    Trees:

    Tree 1:      2            Tree 2:      2
                  \                       /
                   5                     3

    Merged:       4
                /   \
               3     5
    Justification: The root nodes have values 2 each, so the merged tree's root value is 2 + 2 = 4.
    Tree 1 doesn't have a left child, so we take the left child of Tree 2 as it is, which is 3.
    Similarly, Tree 2 doesn't have a right child, so the merged tree's right child is the same as Tree 1, which is 5.
*/

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class MergeTwoBTrees {

    public TreeNode solution(TreeNode t1, TreeNode t2) {
        // If one of the nodes is null, return the other node
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        // Create a new node with the sum of values of t1 and t2.
        TreeNode newNode = new TreeNode(t1.val + t2.val);

        // Recursive call for left and right children.
        newNode.left = solution(t1.left, t2.left);
        newNode.right = solution(t1.right, t2.right);

        return newNode;
    }

}
