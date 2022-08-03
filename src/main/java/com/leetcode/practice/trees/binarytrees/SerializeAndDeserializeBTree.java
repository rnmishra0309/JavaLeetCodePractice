package com.leetcode.practice.trees.binarytrees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.trees.binarytrees.util.TreeNode;

public class SerializeAndDeserializeBTree {
	
	static final Logger logger = LogManager.getLogger(SerializeAndDeserializeBTree.class);
	
	public static String serializedString = "";
	public static Queue<String> queue = new LinkedList<String>();

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            serializedString += "X,";
        } else {
            serializedString += String.valueOf(root.val) + ",";
            serialize(root.left);
            serialize(root.right);
        }
        return serializedString.substring(0, serializedString.length()-1);
    }
    
    public static TreeNode deserialize(String data) {
    	for(String element: data.split(",")) queue.add(element);
    	TreeNode root = deserializeHelper();
    	return root;
    }
	
    public static TreeNode deserializeHelper() {
    	String currValue = queue.poll();
		if(currValue.equals("X")) return null;
		TreeNode root = new TreeNode(Integer.parseInt(currValue));
		root.left = deserializeHelper();
		root.right = deserializeHelper();
		return root;
	}

	public static void main(String[] args) {
    	TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		String data = serialize(root);
		logger.info(data);
		TreeNode node = deserialize(data);
    }
}
