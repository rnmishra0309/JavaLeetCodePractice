package com.leetcode.practice.arrays;

import java.util.*;

public class PascalsTriangleII {
	
	// Solution is math dependent
	public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            row.add((int) ((row.get(row.size() - 1) * (long)(rowIndex - i + 1))/i));
        }
        return row;
    }
	
}
