package com.leetcode.practice.binarysearch;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntersectionOfArray {
	
	static final Logger logger = LogManager.getLogger(IntersectionOfArray.class);
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        List<Integer> result = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int ele: nums1) {
            set.add(ele);
        }
        Arrays.sort(nums2);
        for(int ele: set) {
            int se = binarySearch(nums2, 0, nums2.length - 1, ele);
            if(se != -1) {
                result.add(ele);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
        
    }
    
	public static int binarySearch(int[] nums, int start, int end, int target) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid+1, end, target);
            } else {
                return binarySearch(nums, start, mid - 1, target);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] arr1 = new int[] {4,9,5};
    	int[] arr2 = new int[] {9,4,9,8,4};
    	logger.info(Arrays.toString(intersection(arr1,arr2)));
    }
	
}
