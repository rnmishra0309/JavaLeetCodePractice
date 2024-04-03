package com.leetcode.practice.arrays;

/*
Find the number of unique elements without using an extra space
 */

public class NonDuplicateInstances {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 11};
        System.out.println(remove(arr));
    }

    private static int remove(int[] arr) {
        int distinctElements = 1;
        int l = 0;
        int temp = arr[0];
        while(l <= arr.length - 1) {
            if(temp != arr[l]) {
                distinctElements = distinctElements + 1;
            }
            temp = arr[l];
            l++;
        }
        return distinctElements;
    }

    /*
    Similar problem: Given an unsorted array of numbers and a target ‘key’,
                     remove all instances of ‘key’ in-place and return the new length of the array.
     */
    public int remove1(int[] arr, int key) {
        int nextElement = 0; // Initialize the index of the next element which is not 'key'

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) { // Check if the current element is not equal to 'key'
                arr[nextElement] = arr[i]; // Copy the non-key element to the next available position
                nextElement++; // Increment the index for the next non-key element
            }
        }

        return nextElement; // Return the new length of the modified array
    }

}
