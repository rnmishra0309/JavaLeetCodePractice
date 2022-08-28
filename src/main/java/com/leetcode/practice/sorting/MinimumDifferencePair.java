package com.leetcode.practice.sorting;

import java.util.*;

public class MinimumDifferencePair {
	
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> mappings = new HashMap<Integer, List<List<Integer>>>();
        int minimumDifference = Integer.MAX_VALUE;
        int i = 0, j = 1;
        int diff;
        while(j < arr.length) {
            diff = arr[j] - arr[i];
            minimumDifference = Math.min(minimumDifference, diff);
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(arr[i]);
            subList.add(arr[j]);
            if(mappings.containsKey(diff)) {
                mappings.get(diff).add(subList);
            } else {
                List<List<Integer>> list = new ArrayList<List<Integer>>();
                list.add(subList);
                mappings.put(diff, list);
            }
            i = j++;
        }
        return mappings.get(minimumDifference);
    }
	
}
