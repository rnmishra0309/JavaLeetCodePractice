package com.leetcode.practice.arrays;

public class QuickSelectFindKthSmallestOrLargest {
	
	public int[] arr;
	
	public int findKthSmallestElement(int k) {
		int kthSmallest = quickSelect(0, arr.length - 1, k);
		return kthSmallest;
	}
	
	public int findKthLargestElement(int k) {
		int kthLargest = quickSelect(0, arr.length - 1, arr.length - k);
		return kthLargest;
	}

	private int quickSelect(int low, int high, int kPos) {
		// first find the pivot
		int pivot = partition(low, high);
		// if pivot is the kth position
		if(pivot == kPos) return arr[pivot];
		// if pivot is less than k, search right side
		else if(pivot < kPos) return quickSelect(pivot + 1, high, kPos);
		// else if pivot is more than k, search in the left side
		else return quickSelect(low, pivot - 1, kPos);
	}

	private int partition(int low, int high) {
		int pivot = arr[high], pointer = low;
		for(int i = low; i <= high; i++) {
			if(pivot > arr[pointer]) {
				int temp = arr[pointer];
				arr[pointer] = arr[i];
				arr[i] = temp;
				pointer++;
			}
			int temp = arr[high];
			arr[high] = arr[pointer];
			arr[pointer] = temp;
		}
		return pointer;
	}
	
}
