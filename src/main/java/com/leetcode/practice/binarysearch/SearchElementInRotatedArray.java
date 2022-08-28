package com.leetcode.practice.binarysearch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchElementInRotatedArray {
	
	static final Logger logger = LogManager.getLogger(SearchElementInRotatedArray.class);
	
	/*
	 * 
	 * This was my solution almost done but not bug free:
	 * My approach was to find the minimum element in the sorted rotated array using binary search and 
	 * then using proper binary search
	public static int findMinimumIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(mid == left) return (nums[mid] >= nums[right]) ? right : left;
            if(nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) return mid;
            else if(nums[mid] < nums[mid - 1]) {
                left = mid +1;
            } else if(nums[mid + 1] < nums[mid]) {
                right = mid - 1;
            }
        }
        return left;
    }
    
    public static int binarySearch(int[] nums, int target, int left, int right) {
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    
    public static int search(int[] nums, int target) {
    	if(nums.length == 1) return (nums[0] == target) ? 0 : -1;
        int minimumIndex = findMinimumIndex(nums);
        if(nums[minimumIndex] == target) return minimumIndex;
        else if(target > nums[minimumIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, minimumIndex + 1, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, minimumIndex - 1);
        }
    }
    */
	
	// A very good and short solution is:
	
	//	Formula: If a sorted array is shifted, if you take the middle, 
	//  always one side will be sorted. Take the recursion according to that rule.
	//
	//	1- take the middle and compare with target, if matches return.
	//	2- if middle is bigger than left side, it means left is sorted
	//	2a- if [left] < target < [middle] then do recursion with left, middle - 1 (right)
	//	2b- left side is sorted, but target not in here, search on right side middle + 1 (left), right
	//	3- if middle is less than right side, it means right is sorted
	//	3a- if [middle] < target < [right] then do recursion with middle + 1 (left), right
	//	3b- right side is sorted, but target not in here, search on left side left, middle -1 (right)
	
	public static int search(int[] nums, int target) {
		int mid;
		int left = 0, right = nums.length - 1;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid] >= nums[left]) {
				if(nums[left] <= target && target < nums[mid]) right = mid - 1;
				else left = mid + 1;
			} else {
				if(nums[mid] < target && target <= nums[right]) left = mid + 1;
				else right = mid - 1;
			}
		}
		return -1;
	}
	
    public static void main(String[] args) {
    	int[] arr = new int[] {3,4,5,6,1,2};
    	logger.info(search(arr, 2));
    }
	
}
