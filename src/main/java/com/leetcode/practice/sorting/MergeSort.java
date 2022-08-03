package com.leetcode.practice.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeSort {

	static final Logger logger = LogManager.getLogger(MergeSort.class);
	
	public static int[] arr;
	
	public static int[] mergeSort(int[] arr) {
		if(arr.length <= 1) return arr;
		int pivot = arr.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, pivot));
		int[] right = mergeSort(Arrays.copyOfRange(arr, pivot, arr.length));
		return conquer(left, right);
	}
	
	public static int[] conquer(int[] left, int[] right) {
		int[] ret = new int[left.length + right.length];
		int leftCursor = 0, rightCursor = 0, retCursor = 0;
		while(leftCursor < left.length && rightCursor < right.length) {
			if(left[leftCursor] < right[rightCursor]) ret[retCursor++] = left[leftCursor++];
			else ret[retCursor++] = right[rightCursor++];
		}
		while(leftCursor < left.length) {
			ret[retCursor++] = left[leftCursor++];
		}
		while(rightCursor < right.length) {
			ret[retCursor++] = right[rightCursor++];
		}
		return ret;
	}
	
	public static void main(String[] args) {
		arr = new int[]{10, 9, 8, 7, 6, 5 ,4 ,2, 3, 1};
		logger.info("The array before sorting: " + Arrays.toString(arr));
		arr = mergeSort(arr);
		logger.info("The array after sorting: " + Arrays.toString(arr));
	}
	
}
