package com.leetcode.practice.matrix;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TraverseMatrixSpirally {
	
	static final Logger logger = LogManager.getLogger(TraverseMatrixSpirally.class);
	
	public static int[] spiralTraversal(int[][] matrix) {
		int rows = matrix.length, columns = matrix[0].length;
		int[] result = new int[rows * columns];
		int up = 0, left = 0, right = columns - 1, down = rows - 1;
		int retIndex = 0;
		while(retIndex < rows * columns) {
			// traverse left to right
			for(int col = left; col <= right; col++) {
				result[retIndex++] = matrix[up][col];
			}
			
			// traverse from up to down i.e. downwards
			for(int row = up + 1; row <= down; row++) {
				result[retIndex++] = matrix[row][right];
			}
			
			// check if up != down for traversing right to left
			if(up != down) {
				// traverse from right to left
				for(int col = right - 1; col >= left; col--) {
					result[retIndex++] = matrix[down][col];
				}
			}
			
			// check if left != right for traversing down to up
			if(left != right) {
				// traverse from down to up
				for(int row = down - 1; row > up; row--) {
					result[retIndex++] = matrix[row][left];
				}
			}
			
			// update the direction variables
			left++;
			up++;
			right--;
			down--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		for(int[] inp: arr) {
			logger.info(Arrays.toString(inp));
		}
		logger.info("Spiral Traversal: " + Arrays.toString(spiralTraversal(arr)));
	}
}
