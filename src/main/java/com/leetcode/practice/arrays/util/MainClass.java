package com.leetcode.practice.arrays.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

	static final Logger logger = LogManager.getLogger(MainClass.class);

	public static int totalNumberOfZeros(int[] arr) {
		int count = 0;
		for (int element : arr) {
			if (element == 0) {
				count++;
			}
		}
		return count;
	}

	public static void duplicateZeros(int[] arr) {
		int numberOfZeros = totalNumberOfZeros(arr);
		int[] result = new int[arr.length + numberOfZeros];
		int newArrayIndex = 0;
		int oldArrayIndex = 0;
		while (oldArrayIndex < arr.length) {
			if (arr[oldArrayIndex] == 0) {
				result[newArrayIndex++] = arr[oldArrayIndex++];
				result[newArrayIndex++] = 0;
			} else {
				result[newArrayIndex++] = arr[oldArrayIndex++];
			}
		}
		arr = result;
		List<Integer> resultList = new ArrayList<Integer>();
		for (int element : result) {
			resultList.add(element);
		}
		System.out.println(resultList.toString().strip());
	}

	public static void main(String[] args) {
		int[] nums = new int[7];
		nums = ArraysUtil.insertArrayElements(nums, 1, 2, 3, 4, 5);
		ArraysUtil.printArray(nums);
		nums = ArraysUtil.insertAtEnd(nums, 7);
		ArraysUtil.printArray(nums);
		nums = ArraysUtil.insertAtBeginning(nums, 12);
		ArraysUtil.printArray(nums);
		nums = ArraysUtil.insertAtIndex(nums, 3, 78);
		ArraysUtil.printArray(nums);
		int[] num = {1,0,2,3,4,0,5,0};
		duplicateZeros(num);
	}

}
