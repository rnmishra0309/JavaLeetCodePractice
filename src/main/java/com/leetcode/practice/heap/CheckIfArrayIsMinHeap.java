package com.leetcode.practice.heap;

public class CheckIfArrayIsMinHeap {
	
	// iterative solution
	public static boolean isMinHeapIT(int[] heap) {
		if(heap.length <= 1) return true;
		int index = 0;
		while(index <= ((heap.length - 2)/2)) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			if(heap[index] > heap[left] || (right < heap.length && heap[index] > heap[right])) return false;
			index++;
		}
		return true;
	}
	
	// recursive solution
	public static boolean isMinHeap(int[] heap, int index) {
		// if leaf node the return true
		// As min heap is a complete BTree, we need to only check if the
		// left node is outside the array bounds
		if(2 * index + 1 > heap.length) return true;
		if(heap[index] <= heap[2 * index + 1]
			&& heap[index] >= heap[2 * index + 2]
			&& isMinHeap(heap, 2 * index + 1)
			&& isMinHeap(heap, 2 * index + 2)) return true;
		return false;
	}
}
