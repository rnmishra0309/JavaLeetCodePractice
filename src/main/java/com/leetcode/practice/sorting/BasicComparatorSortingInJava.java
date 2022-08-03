package com.leetcode.practice.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.sorting.util.StringComparatorByLength;

public class BasicComparatorSortingInJava {
	
	static final Logger logger = LogManager.getLogger(BasicComparatorSortingInJava.class);
	
	static public void sortByLength(String[] arr) {
		Arrays.sort(arr, new StringComparatorByLength());
	}
	
	public static void main(String[] args) {
		String[] arr = {"Lexicographically", "Kevin", "Learning", "Bowl", "Passage"};
		logger.info("The arr before sorting is: ");
		for(String ele: arr) logger.info(ele);
		sortByLength(arr);
		logger.info("The arr after sorting is: ");
		for(String ele: arr) logger.info(ele);
	}
}
