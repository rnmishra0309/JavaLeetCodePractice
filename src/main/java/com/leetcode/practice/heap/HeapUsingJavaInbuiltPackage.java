package com.leetcode.practice.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapUsingJavaInbuiltPackage {
	// Construct an empty Min Heap
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	// Construct an empty Max Heap
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	// Construct a Heap with initial elements. 
	// This process is named "Heapify".
	// The Heap is a Min Heap
	PriorityQueue<Integer> heapWithValues= new PriorityQueue<>(Arrays.asList(3, 1, 2));
	
	public void heapOperations() {
		// Insert an element to the Min Heap
		minHeap.add(5);

		// Insert an element to the Max Heap
		maxHeap.add(5);
		
		// Get top element from the Min Heap
		// i.e. the smallest element
		minHeap.peek();
		// Get top element from the Max Heap
		// i.e. the largest element
		maxHeap.peek();
		
		// Delete top element from the Min Heap
		minHeap.poll();

		// Delete top element from the Max Heap
		maxHeap.poll();
		
		// Length of the Min Heap
		minHeap.size();

		// Length of the Max Heap
		maxHeap.size();

		// Note, in Java, apart from checking if the length of the Heap is 0, we can also use isEmpty()
		// If there are no elements in the Heap, isEmpty() will return true;
		// If there are still elements in the Heap, isEmpty() will return false;
	}
}
