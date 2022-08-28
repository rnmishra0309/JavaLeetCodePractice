package com.leetcode.practice.binarysearch;

public class FindARangeOfTarget {
	
	public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int firstOccurance = getBounds(nums, target, true);
        if(firstOccurance == -1) return new int[]{-1, -1};
        int secondOccurance = getBounds(nums, target, false);
        return new int[]{firstOccurance, secondOccurance};
    }
    
    public int getBounds(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(nums[mid] == target) {
                if(isFirst) {
                    if(mid != 0 && nums[mid] == nums[mid - 1]) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    if(mid != nums.length - 1 && nums[mid] == nums[mid+1]) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                }
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
	
}
