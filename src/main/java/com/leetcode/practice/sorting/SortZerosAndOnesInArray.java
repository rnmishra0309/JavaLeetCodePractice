package com.leetcode.practice.sorting;

public class SortZerosAndOnesInArray {

	// input array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
	// count the number 0s = 4
	// number 1 = arr.length - num 0 = 5
	public static int[] sortOnesAndZeros(int[] array) {
		int[] output = new int[array.length];
		int zerosCount = 0;
		int i = 0;
		for (int element : array) {
			if (element == 0)
				zerosCount++;
		}
		for (; i < zerosCount; i++)
			output[i] = 0;
		for (; i < array.length; i++)
			output[i] = 1;
		return output;
	}

	public static void main(String[] args) {
		int[] input = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		int[] output = sortOnesAndZeros(input);
		for (int element : output)
			System.out.println(element);
	}

}
