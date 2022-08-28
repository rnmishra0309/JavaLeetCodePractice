package com.leetcode.practice.binarysearch;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntersectArrayII {
	
	static final Logger logger = LogManager.getLogger(IntersectArrayII.class);
	
	// My Solution -> in efficient. O(NLogN + M(logN + NlogN)) = O(NLogN + MlogN + MNLogN) = o(MNLogN)
	public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums2);
        for(int ele: nums1) {
            int index = binarySearch(nums2, 0, nums2.length-1, ele);
            if(index != -1) {
                nums2[index] = -1;
                Arrays.sort(nums2);
                result.add(ele);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public static int binarySearch(int[] nums, int start, int end, int target) {
        if(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) return binarySearch(nums, mid+1, end, target);
            else return binarySearch(nums, start, mid-1, target);
        }
        return -1;
    }
    
    // Using counting sort approach
    // because nums[i] is between 0 to 1000.
    public static int[] countingApproach(int[] nums1, int[] nums2) {
    	if(nums1.length > nums2.length) {
            return countingApproach(nums2, nums1);
        }
    	int[] counts = new int[1000+1];
    	List<Integer> result = new ArrayList<>();
    	for(int ele: nums2) {
    		counts[ele]++;
    	}
    	for(int ele: nums1) {
    		if(counts[ele] > 0) {
    			result.add(ele);
    			counts[ele]--;
    		}
    	}
    	return result.stream().mapToInt(i -> i).toArray();
    }
    
    public static void main(String[] args) {
    	int[] arr1 = new int[] {1,2,2,1};
    	int[] arr2 = new int[] {1,1};
    	logger.info(Arrays.toString(intersect(arr1,arr2)));
    }
	
}
