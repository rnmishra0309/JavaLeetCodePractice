package com.leetcode.practice.heap;

import java.util.PriorityQueue;

public class FindKthLargestUsingMinHeap {
	// My Solution
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for(int i = 0; i < nums.length; i++) {
            if(minHeap.size() != k) {
                minHeap.add(nums[i]);
            } else {
                int largest = minHeap.peek();
                if(nums[i] > largest) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
