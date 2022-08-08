package com.leetcode.practice.sorting;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BucketSort {
	
	static final Logger logger = LogManager.getLogger(BucketSort.class);
	
	static public int[] arr;
	
	@SuppressWarnings("unchecked")
	public static int[] bucketSort(int bucketSize) {
		int[] result = new int[arr.length];
		List<Integer>[] unsortedBuckets = new ArrayList[bucketSize];
		List<Integer> sortedBuckets = new ArrayList<Integer>();
		int shift = Arrays.stream(arr).min().getAsInt();
		int maxValue = Arrays.stream(arr).max().getAsInt() - shift;
		double divider = (double) maxValue / bucketSize;
		if(divider < 1) divider = 1.0;
		for(int i = 0; i < unsortedBuckets.length; i++) {
			unsortedBuckets[i] = new ArrayList<Integer>();
		}
		for(int element: arr) {
			int index = (int) ((int) (element - shift)/divider);
			if(index == bucketSize) {
				unsortedBuckets[bucketSize - 1].add(element);
			} else {
				unsortedBuckets[index].add(element);
			}
		}
		// sort the unsorted buckets
		for(List<Integer> bucket: unsortedBuckets) {
			Collections.sort(bucket);
		}
		
		// add the elements
		for(List<Integer> bucket: unsortedBuckets) {
			sortedBuckets.addAll(bucket);
		}
		
		// move it into the array
		int index = 0;
		for(Integer element: sortedBuckets) {
			result[index++] = element;
		}
		return result;
	}
	
	public static void main(String[] args) {
		//arr = new int[]{5,5,5,4,4,3,3,2,2,1,1,6,7,7,8,11,11};
		arr = new int[]{23,23,23,12,12,11,10,17,17,17,15,20,22};
		logger.info("Before sorting: " + Arrays.toString(arr));;
		//arr = countingSort();
		arr = bucketSort(10);
		logger.info("After sorting: " + Arrays.toString(arr));
	}
	
}
