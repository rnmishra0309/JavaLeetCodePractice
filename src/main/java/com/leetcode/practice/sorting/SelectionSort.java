package com.leetcode.practice.sorting;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionSort {

	static final Logger logger = LogManager.getLogger(SelectionSort.class);
	
	public static int[] arr;
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void selectionSort() {
		if(arr.length == 0) return;
		int curr = 0;
		while(curr < arr.length - 1) {
			int minIndex = curr;
			int min = minIndex;
			while(minIndex <= arr.length - 1) {
				if (arr[minIndex] < arr[min]) {
					min = minIndex;
				}
				minIndex++;
			}
			swap(curr, min);
			curr++;
		}
	}
	
	public static void main(String[] args) {
		arr = new int[]{10, 9, 8, 7, 6, 5 ,4 ,2, 3, 1};
		logger.info("The array before sorting: " + Arrays.toString(arr));
		selectionSort();
		logger.info("The array after sorting: " + Arrays.toString(arr));
	}
}
