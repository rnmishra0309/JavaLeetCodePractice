package com.leetcode.practice.arrays;

// this is if input array is sorted.
public class TwoSumII {
	
	// My solution
	public int binarySearch(int[] numbers, int start, int end, int number) {
        if(start <= end) {
            int mid = start+(end - start)/2;
            if(numbers[mid] == number) {
                return mid;
            }
            if(numbers[mid] < number) {
                return binarySearch(numbers, mid+1, end, number);
            } else if (numbers[mid] > number) {
                return binarySearch(numbers, start, mid - 1, number);
            }
        }
        return -1;
    }
    
    public int[] twoSumMySolution(int[] numbers, int target) {
        if(numbers.length == 2) return new int[]{1,2};
        for(int index = 0; index < numbers.length; index++) {
            int complement = target - numbers[index];
            int indexOfComplement = binarySearch(numbers, index + 1, numbers.length-1, complement);
            if(indexOfComplement != -1) {
                return new int[]{index+1, indexOfComplement+1};
            }
        }
        return null;
    }
    
    // Optimal solution
    /**
     * We appoint two pointers one at the beginning and second at the end.
     * Then we compute the sum
     * if the sum > target then we need to move to the lower ground
     * meaning we need to decrease the right pointer.
     * Similarly, if the sum < target we need to move to the greater ground
     * meaning we move up the left pointer;
     * 
     */
	public int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int sum = nums[left] + nums[right];
			if(sum == target) {
				return new int[] {left+1, right+1};
			} else if(sum > target) {
				right --;
			} else if(sum < target) {
				left++;
			}
		}
		return null;
	}
	
}
