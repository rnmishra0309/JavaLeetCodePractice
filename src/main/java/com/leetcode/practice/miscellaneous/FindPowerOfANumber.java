package com.leetcode.practice.miscellaneous;

// answer = x to the power n
public class FindPowerOfANumber {
	
	public double bruteForce(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }
	
	// recursive fast power TC: O(logN)
	private double fastPowRecursive(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPowRecursive(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPowRecursive(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPowRecursive(x, N);
    }
    
    // fast power iterative
    public double myPowIterative(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
