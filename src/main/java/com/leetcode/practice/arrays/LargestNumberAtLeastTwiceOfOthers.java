package com.leetcode.practice.arrays;

public class LargestNumberAtLeastTwiceOfOthers {
	// Approach - 1 (My Solution)
	public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        // find the maximum element
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= nums[maxIndex])
                maxIndex = i;
        }
        // re-iterate through the array and check for every element
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != nums[maxIndex] && nums[maxIndex] < 2*nums[i])
                return -1;
        }
        return maxIndex;
    }
	
	// Approach - 2
	public int dominantIndexInArray(int[] nums) {
		int maxOne = 0, maxTwo = 0, index = -1;
		for(int i=0; i<nums.length; i++) {
			if(maxOne < nums[i]) {
				maxTwo = maxOne;
				maxOne = nums[i];
				index = i;
			} else if (maxTwo < nums[i]) {
				maxTwo = nums[i];
			}
		}
		
		return (maxOne >= 2*maxTwo) ? index : -1;
	}
}
