package com.leetcode.practice.heap;

import java.util.*;

/**
 * Find the k frequent element using heaps
 * 
 * arr = [1,1,1,2,2,3], k = 2
 * result = [1,2]
 * @author RudraNM
 *
 */
public class FindKFrequentElementsUsingHeap {
	
	public List<Integer> findKFrequentElements(int[] arr, int k) {
		List<Integer> result = new ArrayList<Integer>();
		// 1. put the elements in the hashmap with frequency
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int element: arr) {
			hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
		}
		// 2. Initialize a MinHeap that takes the frequency of the hashmap
		Queue<Integer> minHeap = new PriorityQueue<Integer>(
				(n1, n2) -> hashMap.get(n1) - hashMap.get(n2));
		// 3. Iterate the hashMap and put the elements in the minHeap
		for(int element: hashMap.keySet()) {
			minHeap.add(element);
			if(minHeap.size() > k) minHeap.poll();
		}
		// 4. Take out all the element in the minHeap as that is the answer.
		while(!minHeap.isEmpty()) result.add(minHeap.poll());
		return result;
	}
	
	// there are more answer in the bucket sort section
	public List<Integer> findKFrequentElementsUsingBucketSort(int[] arr, int k) {
		List<Integer> result = new ArrayList<Integer>();
		// 1. put the elements in the hashmap with frequency
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int element: arr) {
			hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
		}
		// 2. Create arr.length number of buckets
		List<Integer>[] buckets = new List[arr.length + 1];
		for(int i=0; i<=arr.length;i++) buckets[i] = new ArrayList<Integer>();
		// 3. put the key in hashmap to its value as the bucket index
		for(int element: hashMap.keySet()) buckets[hashMap.get(element)].add(element);
		// 4. Flattent the elements from end of buckets to 1
		for(int i=arr.length; i>=1;i--) {
			
		}
		return result;
	}
}
