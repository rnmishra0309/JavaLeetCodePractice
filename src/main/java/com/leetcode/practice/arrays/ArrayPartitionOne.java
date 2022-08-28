package com.leetcode.practice.arrays;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Given an integer array nums of 2n integers, 
 * group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) 
 * such that the sum of min(ai, bi) for all i is maximized. 
 * Return the maximized sum.
 * 
 * Input: nums = [1,4,3,2] 
 * Output: 4 
 * Explanation: All possible pairings (ignoring the ordering of elements) are: 
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3 
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3 
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4 
 * So the maximum possible sum is 4.
 * 
 * Input: nums = [6,2,6,5,1,2]
 * Output: 9
 * Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 * 
 * @author RudraNM
 *
 */
public class ArrayPartitionOne {
	
	static final Logger logger = LogManager.getLogger(CountMaximumConsecutiveOnes.class);
	
	// My solution - O(NlogN) - not efficient
	public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int j = 0, k = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.min(nums[k], nums[j]);
            k+=2;
            j+=2;
        }
        return sum;
    }
	
	// using leetcode soln: Using counting sort
	public static int arrayPairSumUsingCountingSort(int[] nums) {
		//1. initialize K = 10000 as the constraint is 2*10^4+1.
		int K = 10000;
		//2. intialize an array with 2*10^4+1 elements
		int[] elementToCount = new int[2*K+1]; 
		//3. fill in the frequency of the nums in the array
		for(int element: nums) {
			// 3.1 apply the offset
			elementToCount[element + K]++;
		}
		int maxSum = 0;
		boolean isEvenIndex = true;
		//4. iterate through the frequency array and:
		for(int element = 0; element <= 2 * K; element++) {
			//4.1 iterate again till the frequency of that element is zero
			while(elementToCount[element] > 0) {
				//4.1.1 if it is at the even index then add it to the maxsum
				maxSum += (isEvenIndex) ? element - K : 0;
				//4.1.2 flip the isEveneIndex variable
				isEvenIndex = !isEvenIndex;
				//4.1.3 reduce the frequency
				elementToCount[element]--;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,3,2};
		logger.info(arrayPairSum(arr));
		logger.info(arrayPairSumUsingCountingSort(arr));
	}
}
