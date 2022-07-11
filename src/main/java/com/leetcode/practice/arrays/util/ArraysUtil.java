package com.leetcode.practice.arrays.util;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraysUtil {
	
	static final Logger logger = LogManager.getLogger(ArraysUtil.class);
	
	public static void printArray(int[] array) {
		logger.info("The elements in array is: ");
		for(int num: array) {
			logger.info("Item is: " + num);
		}
	}
	
	public static void printArray(byte[] array) {
		logger.info("The elements in array is: ");
		for(byte num: array) {
			logger.info("Item is: " + num);
		}
	}
	
	public static void printArray(float[] array) {
		logger.info("The elements in array is: ");
		for(float num: array) {
			logger.info("Item is: " + num);
		}
	}
	
	public static void printArray(double[] array) {
		logger.info("The elements in array is: ");
		for(double num: array) {
			logger.info("Item is: " + num);
		}
	}
	
	public static void printArray(char[] array) {
		logger.info("The elements in array is: ");
		for(char character: array) {
			logger.info("Item is: " + character);
		}
	}
	
	public static void printArray(boolean[] array) {
		logger.info("The elements in array is: ");
		for(boolean bool: array) {
			logger.info("Item is: " + bool);
		}
	}
	
	public static void printArray(short[] array) {
		logger.info("The elements in array is: ");
		for(short num: array) {
			logger.info("Item is: " + num);
		}
	}
	
	public static int[] insertArrayElements(int[] nums, int... elements) {
		int index = 0;
		while (index < elements.length && index < nums.length) {
			nums[index] = elements[index];
			index++;
		}
		return nums;
	}
	
	public static int[] insertAtEnd(int[] array, int num) {
		try {
			// int[] newArray = new int[array.length + 1];
			// System.arraycopy(array,0,newArray,0,array.length);
			int[] newArray = Arrays.copyOf(array, array.length+1);
			newArray[array.length] = num;
			return newArray;
		} catch (Exception e) {
			logger.info("Error: " + e.toString());
		}
		return null;
	}
	
	public static int[] insertAtBeginning(int[] array, int num) {
		try {
			int[] newArray = new int[array.length+1];
			System.arraycopy(array, 0, newArray, 1, array.length);
			newArray[0] = num;
			return newArray;
		} catch (Exception e) {
			logger.info("Error: " + e.toString());
		}
		return null;
	}
	
	public static int[] insertAtIndex(int[] array, int index, int num) {
		try {
			if (index >= 0 && index < array.length) {
				int[] newArray = new int[array.length + 1];
				int newArrayIndex = 0;
				for(int ind = 0; ind < array.length; ind++) {
					if(ind == index) {
						newArray[newArrayIndex++] = num;
					}
					newArray[newArrayIndex++] = array[ind];
				}
				return newArray;
			}
		} catch (Exception e) {
			logger.info("Error: " + e.toString());
		}
		return null;
	}
}
