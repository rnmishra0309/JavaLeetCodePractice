package com.leetcode.practice.matrix;


/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 * [[1, 2, 3]
 *  [4, 5, 6]
 *  [7, 8, 9]]
 * 
 * output: [1, 2, 4, 7, 5, 3, 6, 8, 9]
 * 
 * Algorithm approaches:
 * 
 * 1. we can see that the rowNumber + columnNumber if it is even the direction is up
 *    else direction is down when odd.
 * 2. to move up: (order of if else matters!!)
 * 			if columnNumber == columnCount - 1 then increment row
 * 			else if rowNumber == 0 then increment column
 * 			else decrement row and increment column
 *    
 *    to move down: (order of if else matters!!)
 *    		if rowNumber == rowCount - 1 then increment column
 *    		else if columnNumber == 0 then increment row
 *    		else increment row and decrement column
 * 
 * 3. Now we can see that moving up is exactly opposite to moving down.
 * 
 * @author RudraNM
 *
 */
public class PrintElementsDiagonallyWithDirectionChange {
	
	public int[] traverseDiagonally(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
		int rowCount = matrix.length, columnCount = matrix[0].length;
		int[] output = new int[rowCount * columnCount];
		int rowNumber = 0, columnNumber = 0, outputIndex = 0;
		for(; outputIndex < output.length; outputIndex++) {
			output[outputIndex] = matrix[rowNumber][columnNumber];
			if((rowNumber + columnNumber) % 2 != 0) {
				if(rowNumber == rowCount - 1) columnNumber++;
				else if(columnNumber == 0) rowNumber++;
				else {
					rowNumber++;
					columnNumber--;
				}
			} else {
				if(columnNumber == columnCount - 1) rowNumber++;
				else if(rowNumber == 0) columnNumber++;
				else {
					rowNumber--;
					columnNumber++;
				}
			}
		}
		return output;
	}
	
}
