package com.leetcode.practice.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickSort {
	
	static final Logger logger = LogManager.getLogger(QuickSort.class);
	
	public static int[] arr;
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		arr = new int[]{10, 9, 8, 7, 6, 5 ,4 ,2, 3, 1};
		logger.info("The array before sorting: " + Arrays.toString(arr));
		quickSortArray();
		logger.info("The array after sorting: " + Arrays.toString(arr));
	}

	public static void quickSortArray() {
		quickSort(0, arr.length - 1);
	}
	
	public static void quickSort(int low, int high) {
		if(low < high) {
			int pivot = partition(low, high);
			quickSort(0, pivot-1);
			quickSort(pivot+1, high);
		}
	}
	
	public static int partition(int low, int high) {
		int pivot = arr[high];
		int i = low;
		for(int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				swap(i, j);
				i++;
			}
		}
		swap(i, high);
		return i;
	}
	
}
