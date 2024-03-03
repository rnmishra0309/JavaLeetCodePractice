package com.leetcode.practice.arrays;

import java.util.*;

/*

Problem Statement:- Given an array of integers nums, return the number of good pairs.
                    A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.


Example 3:

Input: nums = [1,2,3]
Output: 0



MY SOLUTION (I thought it through):

First store the frequency of every element in the hash map.
The iterate over the hash map and according to the frequency add the number of possible pairs from the frequency.

For example:

If frequency is 1 then good pairs will be 0
If frequency is 2 then good pairs will be 1 [prev + {1}]
If frequency is 3 then good pairs will be 3 [prev + {2}]
If frequency is 4 then good pairs will be 6 [prev + {3}]
If frequency is 5 then good pairs will be 10 [prev + {4}]
If frequency is 6 then good pairs will be 15 [prev + {5}]
If frequency is 7 then good pairs will be 21 [prev + {6}]

From the above sequence we found out that the difference between each element is an Arithmetic Progression where,

if frequency is `n` then the good pairs will be `SUM(1 + 2 + 3 + 4 + .... + (n-1))` which is `[((n-1)*(n))/2]`



MORE TYPE OF SOLUTION:

Approach
* We will initialize ans with 0 and an empty unordered map to store the occurrence of the element
* For each element in the given array:
        Here there will be 2 cases
            if element/number is present in the map that means for example at any time in unordered map we saw count of num(element) 1 is 2 that's means current element can form 2 pair with previous 1, so at that time we will add this count in answer and also increase the count of the element in out map
            If element/number is not present in the map, it means this is the first time we're seeing this number, so we initialize its count to 1.
  At last, we will return our answer

*/

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, n = 0;

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], (map.getOrDefault(nums[i], 0) + 1));
        }

        for(Integer key: map.keySet()) {
            if(map.get(key) > 1) {
                n = map.get(key) - 1;
                result += ((int) ((n * (n + 1)) / 2));
            }
        }

        return result;
    }

    public int numIdenticalPairsSol2(int[] A) {
        int ans = 0;
        int[] cnt = new int[101];
        for (int a: A) {
            ans += cnt[a]++;
        }
        return ans;
    }

}
