package com.leetcode.practice.arrays;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquaringItemsAndSorting {
	
	static final Logger logger = LogManager.getLogger(SquaringItemsAndSorting.class);
	
	public static int[] sortedSquares(int[] nums) {
        int index=0;
        while(index < nums.length) {
            nums[index] = nums[index]*nums[index];
            index++;
        }
        Arrays.sort(nums);
        return nums;
    }

	public static void main(String[] args) {
		int[] nums = {-4, -3, 0, 4, 67};
		int i = 0;
		int[] result = sortedSquares(nums);
		logger.info("The array after squaring and sorting is: ");
		while(i < result.length) {
			logger.info("Item: " + result[i++]);
		}
	}

}
