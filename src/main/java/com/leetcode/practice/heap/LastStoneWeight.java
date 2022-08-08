package com.leetcode.practice.heap;

import java.util.*;

public class LastStoneWeight {
	
	// My solution - 99% than java soln with 90% in space complexity
	// completed within 10mins
	/**
	 * Logic is:
	 * 
	 * 1. Put all the elements in the maxHeap.
	 * 2. poll two elements.
	 * 3. find the difference.
	 * 4. Add the difference back to the maxHeap if it is not 0.
	 * 5. Repeat this until the heap size is greater than 1.
	 * 
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight(int[] stones) {
        if(stones.length <= 1) return stones[0];
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int stone: stones) maxHeap.offer(stone);
        while(maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int heavier = maxHeap.poll();
            int difference = heaviest - heavier;
            if(difference > 0) maxHeap.offer(difference);
        }
        return (maxHeap.size() > 0) ? maxHeap.poll() : 0;
    }
	
	
}
