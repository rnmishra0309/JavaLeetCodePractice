package com.leetcode.practice.arrays;

/**
 * This problem can be also used to find the sum of array with 0s and 1s
 * By first sorting it using the tricky solution then using this method to find
 * the sum.
 * @author RudraNM
 *
 */
public class FindSumOfArrayWithOnesAndZeros {
	
	public static int[] arr;
	
	// TC: O(LogN)
	// if array such that 1s are first then 0s
	// arr = [1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0]
	public static int binarySearchForSum() {
		int low = 0;
		int high = arr.length;
		while(low < high) {
			int mid = (low + high) / 2;
			if(arr[mid] == 1) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		arr = new int[] {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println("Sum: " + binarySearchForSum());
	}
}