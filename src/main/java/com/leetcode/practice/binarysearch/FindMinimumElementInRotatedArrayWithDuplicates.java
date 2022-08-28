package com.leetcode.practice.binarysearch;

public class FindMinimumElementInRotatedArrayWithDuplicates {
	
	public int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		int mid;
		while(low < high) {
			mid = low + (high - low)/2;
			if(nums[mid] < nums[high]) {
				high = mid;
			} else if(nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high -= 1;
			}
		}
		return nums[low];
	}
	
}
