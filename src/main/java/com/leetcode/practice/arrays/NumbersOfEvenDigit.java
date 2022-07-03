package com.leetcode.practice.arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumbersOfEvenDigit {
	
	static final Logger logger = LogManager.getLogger(NumbersOfEvenDigit.class);
	
	/**
	 * my solution to get count of digits and this is the efficient solution
	 * time comp: O(n)
	 * space comp: O(1)
	 * @param num
	 * @return
	 */
	public static boolean isDigitCountEven(int num) {
        int digitCount = 0;
        int temp = Math.abs(num);
        if(temp >= 0 && temp <= 9){
            return false;
        }
        while(temp >= 1) {
            temp = temp/10;
            digitCount++;
        }
        if(digitCount % 2 == 0){
            return true;
        }
        return false;
    } 
	
	/**
	 * my driving function
	 * time comp: O(n)
	 * space comp: O(1)
	 * @param nums
	 * @return
	 */
    public static int findNumbers(int[] nums) {
        int result = 0;
        int index = 0;
        while(index < nums.length){
            if(isDigitCountEven(nums[index])){
                result++;
            }
            index++;
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {234, 4567, 12, 345678};
		logger.info("The number of even digits are: " + findNumbers(nums));
	}

}
