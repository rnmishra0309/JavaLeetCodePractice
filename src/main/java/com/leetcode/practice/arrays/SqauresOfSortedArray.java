package com.leetcode.practice.arrays;

public class SqauresOfSortedArray {

    // My approach
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int pos = Integer.MAX_VALUE, neg = Integer.MIN_VALUE;
        if(arr[0] < 0) neg = 0;
        int t;
        for(int i=0; i < n; i++) {
            if(arr[i] >= 0) {
                pos = i;
                break;
            }
        }

        if(neg == 0) {
            while(neg < n) {
                if(arr[neg] >= 0) break;
                arr[neg] = arr[neg] * arr[neg];
                neg++;
            }
            --neg;
        }

        if(pos < n) {
            while(pos < n) {
                arr[pos] = arr[pos] * arr[pos];
                pos++;
            }
            if(neg >= 0 && neg < n) pos = neg + 1;
            else pos = 0;
        }
        int j = 0;
        while(j < n) {
            if(neg >= 0 && pos < n && arr[neg] > arr[pos]) squares[j] = arr[pos++];
            else if(neg >= 0 && pos < n && arr[neg] < arr[pos]) squares[j] = arr[neg--];
            else if(neg >= 0 && pos < n && arr[neg] == arr[pos]) {
                squares[j++] = arr[neg--];
                squares[j] = arr[pos++];
            }
            else if(neg < 0 && pos < n) squares[j] = arr[pos++];
            else if(neg >= 0 && pos >= n) squares[j] = arr[neg--];
            else break;
            j++;
        }
        return squares;
    }

    // optimized method, same concept just optimized code
    public int[] makeSquaresOptimized(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n]; // Create an array to store the squared values.
        int highestSquareIdx = n - 1; // Initialize the index to store the highest squared value.
        int left = 0, right = arr.length - 1; // Initialize two pointers, one at the beginning and one at the end of the input array.

        // Iterate over the input array from both ends towards the center.
        while (left <= right) {
            int leftSquare = arr[left] * arr[left]; // Calculate the square of the value at the left pointer.
            int rightSquare = arr[right] * arr[right]; // Calculate the square of the value at the right pointer.

            if (leftSquare > rightSquare) {
                // If the square of the value at the left pointer is greater, store it in the squares array
                // at the current highestSquareIdx and move the left pointer to the right.
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                // If the square of the value at the right pointer is greater or equal, store it in the squares array
                // at the current highestSquareIdx and move the right pointer to the left.
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares; // Return the sorted array of squared values.
    }

}
