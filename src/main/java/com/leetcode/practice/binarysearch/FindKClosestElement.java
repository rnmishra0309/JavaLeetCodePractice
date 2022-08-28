package com.leetcode.practice.binarysearch;

import java.util.*;

public class FindKClosestElement {

	// Binary Search Approach - O(log(N-k)+k)
	public List<Integer> findClosestElements(int[] nums, int k, int x) {
		int left = 0;
		int right = nums.length - k;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (x - nums[mid] > nums[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = left; i < left + k; i++)
			result.add(nums[i]);
		return result;
	}

	// Min-Heap based approach - O(NlogK)
	public List<Integer> findClosestElementsUsingHeap(int[] arr, int k, int x) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (Math.abs(a - x) == Math.abs(b - x)) {
					return Integer.compare(a, b);
				} else {
					return Integer.compare(Math.abs(a - x), Math.abs(b - x));
				}
			}
		});
		for (int num : arr) {
			minHeap.offer(num);
		}
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			answer.add(minHeap.poll());
		}
		Collections.sort(answer);
		return answer;
	}
	
	public static void main(String[] args) {
		char a = 'a';
		char z = 'z';
		char c = (char) ((char) (a- z) % z);
		int ai = a;
		int zi = z;
		int ci = (a - z) % z;
		System.out.println(c + " -> " + ci + " " + ai + " " + zi);
		for(char i = 'a'; i <= 'z'; i++) {
			int j = ((int) i - 97);
			System.out.println(i + " " + j + " " + j % 25);
		}
	}

}
