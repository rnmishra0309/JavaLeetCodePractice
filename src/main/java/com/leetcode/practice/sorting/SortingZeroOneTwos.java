package com.leetcode.practice.sorting;

public class SortingZeroOneTwos {
	// My Solution beats 100% of java solutions and beats 96.5% of space comp.
	public void sortColors(int[] nums) {
        int countZero = 0, countOne = 0, countTwo = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) countZero++;
            else if(nums[i] == 1) countOne++;
            else if(nums[i] == 2) countTwo++;
        }
        int resultIndex = 0;
        while(countZero > 0 && resultIndex < nums.length) {
            nums[resultIndex++] = 0;
            countZero--;
        }
        while(countOne > 0 && resultIndex < nums.length) {
            nums[resultIndex++] = 1;
            countOne--;
        }
        while(countTwo > 0 && resultIndex < nums.length) {
            nums[resultIndex++] = 2;
            countTwo--;
        }
    }
	
	// More efficient solution is Dutch National Flag problem by Dijiktra
	public void dutchNationalFlagApproach(int[] nums) {
		int p0 = 0, curr = 0, p2 = nums.length - 1;
		int temp;
		while(curr <= p2) {
			if(nums[curr] == 0) {
				temp = nums[curr];
				nums[curr] = nums[p0];
				nums[p0] = temp;
				p0++;
				curr++;
			} else if(nums[curr] == 2) {
				temp = nums[curr];
				nums[curr] = nums[p2];
				nums[p2] = temp;
				p2--;
			} else curr++;
		}
	}
}
