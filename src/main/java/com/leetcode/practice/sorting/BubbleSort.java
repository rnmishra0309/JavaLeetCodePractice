package com.leetcode.practice.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSort {
	
	static final Logger logger = LogManager.getLogger(BubbleSort.class);
	
	public static int[] arr;
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void bubbleSort() {
		if(arr.length == 0) return;
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] > arr[i+1]) {
					swap(i, i+ 1);
					hasSwapped = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		arr = new int[]{10, 9, 8, 7, 6, 5 ,4 ,2, 3, 1};
		logger.info("The array before sorting: " + Arrays.toString(arr));
		bubbleSort();
		logger.info("The array after sorting: " + Arrays.toString(arr));
	}
	
}
