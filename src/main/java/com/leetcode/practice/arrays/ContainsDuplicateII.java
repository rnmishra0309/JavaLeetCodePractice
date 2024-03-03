package com.leetcode.practice.arrays;

import java.util.*;

public class ContainsDuplicateII {

    // My Solution
    public static boolean containsNearbyDuplicates(int[] nums, int k) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.containsKey(num)) {
                for(int j: hashMap.get(num)) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                hashMap.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(num, list);
            }
        }
        return false;
    }

    public static boolean efficientSolution(int[] nums, int k) {
        // maintain a sliding window of k+1 and use hashSet
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicates(nums, k));
    }

}
