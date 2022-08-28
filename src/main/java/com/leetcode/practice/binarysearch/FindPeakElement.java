package com.leetcode.practice.binarysearch;

public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        return peakElement(nums, 0, nums.length - 1);
    }
    
    public int peakElement(int[] nums, int start, int end) {
        if(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(nums[mid] < nums[mid+1]) {
                return peakElement(nums, mid, end);
            } else {
                return peakElement(nums, start, mid);
            }
        }
        return start;
    }
	
}
