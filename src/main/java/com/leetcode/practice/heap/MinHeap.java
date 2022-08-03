package com.leetcode.practice.heap;

import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinHeap {
	
	static final Logger logger = LogManager.getLogger(MinHeap.class);
	
	// store the heap elements using Vector
	private Vector<Integer> heap;
	
	public MinHeap() {
		heap = new Vector<Integer>();
	}
	
	public MinHeap(int capacity) {
		heap = new Vector<Integer>(capacity);
	}
	
	private int getParentNode(int index) {
		// If the index is for the root node.
		if(index == 0) return 0;
		return ((index - 1) / 2);
	}
	
	private int getLeftNode(int index) {
		return (2 * index + 1);
	}
	
	private int getRightNode(int index) {
		return (2 * index + 2);
	}
	
	private void swap(int firstIndex, int secondIndex) {
		int temp = heap.get(firstIndex);
		heap.setElementAt(heap.get(secondIndex), firstIndex);
		heap.setElementAt(temp, secondIndex);
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public boolean contains(int element) {
		return heap.contains(element);
	}
	
	public Integer[] toArray() {
		return heap.toArray(new Integer[heap.size()]);
	}
	
	private void heapifyDown(int index) {
		int left = getLeftNode(index);
		int right = getRightNode(index);
		int smallest = index;
		if(left < size() && heap.get(left) <= heap.get(index)) smallest = left;
		if(right < size() && heap.get(right) <= heap.get(index)) smallest = right;
		if(smallest != index) {
			swap(smallest, index);
			heapifyDown(smallest);
		}
	}
	
	private void heapifyUp(int index) {
		int parent = getParentNode(index);
		if(index > 0 && heap.get(parent) > heap.get(index)) {
			swap(index, parent);
			heapifyUp(parent);
		}
	}
	
	public void push(int key) {
		heap.addElement(key);
		int index = size() - 1;
		heapifyUp(index);
	}
	
	public Integer pop() {
		try {
			if(isEmpty()) throw new Exception("Heap is empty (Under flow).");
			int root = heap.firstElement(); // heap.get(0);
			heap.setElementAt(heap.lastElement(), 0);
			heap.remove(size() - 1);
			heapifyDown(0);
			return root;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer peek() {
		try {
			if(isEmpty()) throw new Exception("Heap is empty (Under flow).");
			return heap.firstElement();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
