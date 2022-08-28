package com.leetcode.practice.binarysearch;

public class BinarySearch {
	
	// recursive approach
	public int binarySearch(int[] nums, int start, int end, int target) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid+1, end, target);
            } else {
                return binarySearch(nums, start, mid - 1, target);
            }
        }
        return -1;
    }
	
	// iterative approach
	// template I
	public int binarySearch(int[] nums, int target) {
		int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) {
                start = mid+1;
                continue;
            } else {
                end = mid - 1;
                continue;
            }
        }
		return -1;
	}
	
}
