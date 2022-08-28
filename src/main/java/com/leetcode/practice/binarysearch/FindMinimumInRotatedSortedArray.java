package com.leetcode.practice.binarysearch;

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		return (nums.length == 1) ? nums[0] : nums[findMin(nums, 0, nums.length - 1)];
	}

	public int findMin(int[] nums, int left, int right) {
		if (nums[left] < nums[right])
			return 0;

		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] > nums[pivot + 1])
				return pivot + 1;
			else {
				if (nums[pivot] < nums[left])
					right = pivot - 1;
				else
					left = pivot + 1;
			}
		}
		return 0;
	}

}
