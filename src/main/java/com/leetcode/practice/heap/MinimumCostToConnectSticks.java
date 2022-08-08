package com.leetcode.practice.heap;

import java.util.*;

public class MinimumCostToConnectSticks {
	
	// My Solution
	public int connectSticks(int[] sticks) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int totalCost = 0;
        for(int stick: sticks) minHeap.offer(stick);
        while(minHeap.size() > 1) {
            int stickOne = minHeap.poll();
            int stickTwo = minHeap.poll();
            int cost = stickOne + stickTwo;
            totalCost += cost;
            minHeap.offer(cost);
        }
        return totalCost;
    }
	
}
