package com.leetcode.practice.algorithms.recursion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KthGrammar {
	
	static final Logger logger = LogManager.getLogger(KthGrammar.class);
	
	// My Solution - Not so efficient but works fine
	public static int kthGrammar(int n, int k) {
        String result = kthGrammarHelper(n);
        logger.info(result.length());
        return Integer.parseInt(String.valueOf(result.charAt(k-1)));
    }
    
    public static String kthGrammarHelper(int n) {
        StringBuilder result = new StringBuilder();
        if(n == 1) {
            result.append("0");
            return result.toString();
        }
        String prevResult = kthGrammarHelper(n-1);
        for(int i = 0; i < prevResult.length(); i++) {
            if(prevResult.charAt(i) == '0') result.append("01");
            else if(prevResult.charAt(i) == '1') result.append("10");
        }
        return result.toString();
    }
    
    // Leetcode solution 1
    
    
    public static void main(String[] args) {
    	logger.info(kthGrammar(30, 3));
    }
	
}
