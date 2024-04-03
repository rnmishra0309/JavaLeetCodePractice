package com.leetcode.practice.arrays;

/*
Move all the unique number instances at the beginning of the array
and after moving return the array.
 */

import java.util.Arrays;

public class MoveDuplicatesToEnd {

    public static int[] remove(int[] arr) {
        int nextNonDuplicate = 1;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] != arr[nextNonDuplicate - 1]) {
                arr[nextNonDuplicate] = arr[i];
                arr[i] = arr[nextNonDuplicate];
                nextNonDuplicate++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(remove(new int[]{2, 3, 3, 3, 6, 9, 9})));
    }

}
