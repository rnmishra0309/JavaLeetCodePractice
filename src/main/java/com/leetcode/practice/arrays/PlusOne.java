package com.leetcode.practice.arrays;

import java.util.Arrays;

public class PlusOne {
	
	// MY solution
	public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 0, sum = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(i == digits.length - 1) {
                sum = (digits[i] + 1) % 10;
                carry = (digits[i] + 1) / 10;
                result[i+1] = sum;
            } else {
                sum = (digits[i] + carry) % 10;
                carry = (digits[i] + carry) / 10;
                result[i+1] = sum;
            }
        }
        if (carry > 0) {
            result[0] = carry;
            return result;
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }
	
	// A more efficient solution
	public int[] pluOneEfficient(int[] digits) {
		
		for (int i=digits.length-1; i>=0; i--){
	        if (digits[i]<9){
	            digits[i]+=1;
	            return digits;
	        }
	        digits[i]=0;
	    }
	    
	    int[] result = new int[digits.length+1];
	    result[0] = 1;
	    return result;
	}
	
}
