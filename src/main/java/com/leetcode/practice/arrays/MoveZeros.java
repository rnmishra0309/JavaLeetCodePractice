package com.leetcode.practice.arrays;

public class MoveZeros {
	
	//My solution - Accepted at once
	public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0, j = 0;
        while( i < nums.length && j < nums.length) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        
        while(i < nums.length) {
            nums[i++] = 0;
        }
    }
	
}
