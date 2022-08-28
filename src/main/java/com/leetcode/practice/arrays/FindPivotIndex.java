package com.leetcode.practice.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left
 * of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
 * This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * Input: nums = [1,7,3,6,5,6] 
 * Output: 3 
 * Explanation: 
 * The pivot index is 3. 
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * 
 * @author RudraNM
 *
 */
public class FindPivotIndex {
	//Trick: RightSum = totalSumOfArray - leftSum - nums[i]
	public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        int rightSum = 0;
        int i = 0;
        while(i < nums.length) {
            rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
            i++;
        }
        return -1;
    }
}
