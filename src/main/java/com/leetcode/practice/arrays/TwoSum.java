package com.leetcode.practice.arrays;

import java.util.*;

// classic interview problem
public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), index};
            }
            map.put(nums[index], index);
        }
        return null;
    }
	
}
