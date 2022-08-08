package com.leetcode.practice.heap;

import java.util.*;

public class FindKWeakestRows {
	
	// My Solution accepted at first but not much efficient, doing the 
	// same approach though
	public int[] kWeakestRowsMySolution(int[][] mat, int k) {
        int[] result = new int[k];
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int[] soldierCount = new int[mat.length];
        for(int i=0; i < mat.length; i++) {
            soldierCount[i] = Arrays.stream(mat[i]).sum();
        }
        for(int count: soldierCount) {
            minHeap.offer(count);
        }
        for(int i=0; i<k; i++) {
            int row = minHeap.poll();
            int j = 0;
            for(; j < mat.length; j++) {
                if(soldierCount[j] == row) {
                    soldierCount[j] = -9999;
                    break;
                }
            }
            result[i] = j;
        }
        return result;
    }
	
	// LeetCode soln
	public int binarySearch(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			if(arr[mid] == 1) low = mid + 1;
			else high = mid;
		}
		return low;
	}
	
	public int[] kWeakestRows(int[][] mat, int k) {
		int m = mat.length;
		
		Queue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> {
			if (a[0] == b[0]) return b[1] - a[1];
			else return b[0] - a[0];
		});
		
		for(int i = 0; i < m; i++) {
			int strength = binarySearch(mat[i]);
			int[] pair = new int[] {strength, i};
			maxHeap.offer(pair);
			if(maxHeap.size() > k) maxHeap.poll();
		}
		
		int[] result = new int[k];
		for(int i = k-1; i >=0; i--) {
			result[i] = maxHeap.poll()[1];
		}
		return result;
	}
	
}
