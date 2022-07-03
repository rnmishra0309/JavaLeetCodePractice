package com.leetcode.practice.arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountMaximumConsecutiveOnes {
	
	static final Logger logger = LogManager.getLogger(CountMaximumConsecutiveOnes.class);
	
	/**
	 * my solution:
	 * space comp: O(n)
	 * time comp: O(n)
	 * @param nums
	 * @return
	 * 
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
        int[] count = new int[nums.length];
        int countIndex = 0;
        int max = count[0];
        for(int index=0; index < nums.length; index++){
            if(nums[index] == 1){
                count[countIndex]++;
            } else if(nums[index] == 0){
                countIndex++;
            }
        }
        for(int index=0; index<count.length;index++){
            if(max<=count[index]){
                max = count[index];
            }
        }
        return max;
    }
	
	/**
	 * Efficient solution
	 * space comp: O(1)
	 * time comp: O(n)
	 * @param nums
	 * @return
	 */
	public static int efficientFindMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maximum = 0;
		int index = 0;
		while(index < nums.length) {
			if(nums[index] == 0) {
				count = 0;
				index++;
			} else {
				count++;
				maximum = Math.max(maximum, count);
				index++;
			}
		}
		return maximum;
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, 1, 1, 1, 0};
		logger.info("The maximum number of ones are: " + findMaxConsecutiveOnes(nums));
		logger.info("The maximum number of ones are: " + efficientFindMaxConsecutiveOnes(nums));
	}

}
