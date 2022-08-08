package com.leetcode.practice.heap;

import java.util.*;

public class FindKthLargestInAStream {
	private int size;
    private Queue<Integer> heap;
    
    public FindKthLargestInAStream(int k, int[] nums) {
        this.size = k;
        heap = new PriorityQueue<Integer>();
        for(int num: nums) heap.offer(num);
        while(heap.size() > size) heap.poll();
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > size) heap.poll();
        return heap.peek();
    }
}
