package com.leetcode.practice.strings;

import java.math.BigInteger;

public class AddBinaryStrings {
	
	// this is using classical addition problem
	/**
	 * Algo:
	 * 1. put a as the bigger string than b to make things easier.
	 * 2. start from the end of two strings
	 * 3. if a has 1 then increment carry
	 * 4. if b has 1 then increment carry
	 * 5. check if carry % 2 == 1 if yes then add result as 1 else 0
	 * 6. update carry /= 2
	 * 7. after loop, if carry remains add 1 to the result
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		int lenA = a.length(), lenB = b.length();
		if (lenB > lenA) return addBinary(b, a);
		StringBuilder result = new StringBuilder();
		int j = lenB - 1, carry = 0;
		for(int i = lenA-1; i >= 0; i--) {
			if(a.charAt(i) == '1') ++carry;
			if(j >= 0 && b.charAt(j--) == '1') ++carry;
			if(carry % 2 == 1) result.append('1');
			else result.append('0');
			carry /= 2;
		}
		if(carry == 1) result.append('1');
		return result.reverse().toString();
    }
	
	// Using bit manipulation
	public String addBinaryUsingBitManipulation(String a, String b) {
		BigInteger bOne = new BigInteger(a, 2);
		BigInteger bTwo = new BigInteger(b, 2);
		BigInteger zero = new BigInteger("0", 2);
		BigInteger carry, answer;
		while(bTwo.compareTo(zero) != 0) {
			answer = bOne.xor(bTwo);
			carry = bOne.xor(bTwo).shiftLeft(1);
			bOne = answer;
			bTwo = carry;
		}
		return bOne.toString(2);
	}
	
}
