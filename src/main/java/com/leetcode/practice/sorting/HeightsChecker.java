package com.leetcode.practice.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HeightsChecker {
	
	static final Logger logger = LogManager.getLogger(HeightsChecker.class);
	
	public static int[] insertionSort(int[] arr) {
        int end = 1;
        int temp, curr;
        while(end < arr.length) {
            curr = end;
            for(; curr>0; curr--) {
                if(arr[curr] < arr[curr-1]) {
                    temp = arr[curr];
                    arr[curr] = arr[curr-1];
                    arr[curr-1] = temp;
                }
            }
            end++;
        }
        return arr;
    }
    
    public static int heightChecker(int[] heights) {
        int[] expectedHeights = insertionSort(Arrays.copyOf(heights, heights.length));
        logger.info("The array After sorting: " + Arrays.toString(expectedHeights));
        int count = 0;
        for(int i=0;i<heights.length;i++) {
            if(heights[i] != expectedHeights[i]) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
		int[] arr = {1, 1, 4, 2, 1, 3};
		logger.info("The array before sorting: " + Arrays.toString(arr));
		int count = heightChecker(arr);
		logger.info("Count: " + count);
	}
}
