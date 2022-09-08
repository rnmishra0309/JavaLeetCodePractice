package com.leetcode.practice.sorting;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountingSort {
	
	static final Logger logger = LogManager.getLogger(CountingSort.class);
	
	public static int[] arr;
	
	// my implementation
	public static int[] countingSort() {
		if(arr.length == 0) return arr;
		int[] result = new int[arr.length];
		int max = Arrays.stream(arr).max().getAsInt();
		int[] counts = new int[max+1];
		// int[] startingIndices = new int[max+1]; // my implementation
		int countIndex = 0, startingIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			counts[arr[i]]++;
		}
		// my implementation
		//while(countIndex < counts.length - 1) {
		//	startingIndices[standardIndex] = startingIndices[standardIndex-1] + counts[countIndex];
		//	standardIndex++;
		//	countIndex++;
		//}
		// leetcode implementation
		for(; countIndex < counts.length; countIndex++) {
			int count = counts[countIndex];
			counts[countIndex] = startingIndex;
			startingIndex += count;
		}
		// My Implementation
		//for(int i = 0; i < arr.length; i++) {
		//	result[startingIndices[arr[i]]] = arr[i];
		//	startingIndices[arr[i]]++;
		//}
		// Leetcode Implementation
		for(int element: arr) {
			result[counts[element]] = element;
			counts[element]++;
		}
		return result;
	}
	
	// More efficient solution By shifting the elements if min > 0 and max > 0 and min < max
	public static int[] countingSortWithShift() {
		if(arr.length == 0) return arr;
		int[] result = new int[arr.length];
		int shift = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt() - shift;
		int[] counts = new int[max+1];
		int countIndex = 0, startingIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			counts[arr[i] - shift]++;
		}
		for(; countIndex < counts.length; countIndex++) {
			int count = counts[countIndex];
			counts[countIndex] = startingIndex;
			startingIndex += count;
		}
		for(int element: arr) {
			result[counts[element - shift]] = element;
			counts[element - shift]++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		//arr = new int[]{5,5,5,4,4,3,3,2,2,1,1,6,7,7,8,11,11};
		arr = new int[]{23,23,23,12,12,11,10,17,17,17,15,20,22};
		logger.info("Before sorting: " + Arrays.toString(arr));;
		//arr = countingSort();
		arr = countingSortWithShift();
		logger.info("After sorting: " + Arrays.toString(arr));
	}
	
}
