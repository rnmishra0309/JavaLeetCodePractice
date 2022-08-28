package com.leetcode.practice.arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinimumSubArrayLength {
	
	static final Logger logger = LogManager.getLogger(MinimumSubArrayLength.class);
	
	// My Solution - Partial Answer
	public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] == target) return 1;
        else if(nums.length == 1 && nums[0] != target) return 0;
        else {
            int i = -1, j = 0;
            int sum = 0, count = 0, minCount = Integer.MAX_VALUE;
            while(i < nums.length && j < nums.length) {
                if(nums[j] == target) return 1;
                sum += nums[j];
                count++;
                if(sum >= target) {
                    minCount = Math.min(count, minCount);
                    count = 0;
                    sum = 0;
                }
                i = j++;
            }
            return (minCount != Integer.MAX_VALUE) ? minCount : 0;  
        }
    }
	
	// Full Solution
	/*
	 * Intuition
	Until now, we have kept the starting index of subarray fixed, and found the last position. 
	Instead, we could move the starting index of the current subarray as soon as we know that no better could be done with this index as 
	the starting index. We could keep 2 pointer,one for the start and another for the end of the current subarray, 
	and make optimal moves so as to keep the \text{sum}sum greater than ss as well as maintain the lowest size possible.

	* Algorithm

		* Initialize left pointer to 0 and sum to 0
		* Iterate over the nums:
			*Add nums[i] to sum
			*While sum is greater than or equal to ss:
				*Update ans=min(ans,i+1−left), where i+1−left is the size of current subarray
				* It means that the first index can safely be incremented, since, 
				  the minimum subarray starting with this index with sum >= target has been achieved
				* Subtract nums[left] from sum and increment left 
	*/
	public static int getMaximumSubArrayLength(int target, int[] nums) {
		int n = nums.length;
        int minCount = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum >= target) {
                minCount = Math.min(minCount, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (minCount != Integer.MAX_VALUE) ? minCount : 0;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		logger.info(getMaximumSubArrayLength(11, nums));
	}
	
}
