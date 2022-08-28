package com.leetcode.practice.matrix;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PascalTriangle {
	
	static final Logger logger = LogManager.getLogger(PascalTriangle.class);
	
	public static List<List<Integer>> pascalTriangle(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int row = 0; row < numRows; row++) {
            List<Integer> subList = new ArrayList<Integer>();
            int numElements = row + 1;
            if(row <= 1) {
                while(subList.size() < numElements) {
                    subList.add(1);
                }
            } else {
                subList.add(1);
                List<Integer> prevList = result.get(row - 1);
                for(int index = 0; index < prevList.size() - 1; index++) {
                    subList.add((prevList.get(index) + prevList.get(index+1)));
                }
                subList.add(1);
            }
            result.add(subList);
        }
        return result;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> result = pascalTriangle(6);
		for(List<Integer> list: result) {
			logger.info(list.toString());
		}
	}
	
}
