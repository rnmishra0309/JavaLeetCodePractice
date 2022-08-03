package com.leetcode.practice.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort {
	
	static final Logger logger = LogManager.getLogger(InsertionSort.class);
	
	public static int[] arr;
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void insertionSort() {
		if(arr.length == 0) return;
		int end = 1;
		while(end < arr.length) {
			int curr = end;
			for(; curr > 0; curr--) {
				if(arr[curr] < arr[curr-1]) {
					swap(curr, curr-1);
				}
			}
			end++;
		}
	}
	
	public static void main(String[] args) {
		arr = new int[]{10, 9, 8, 7, 6, 5 ,4 ,2, 3, 1};
		logger.info("The array before sorting: " + Arrays.toString(arr));
		insertionSort();
		logger.info("The array after sorting: " + Arrays.toString(arr));
	}
	
}
