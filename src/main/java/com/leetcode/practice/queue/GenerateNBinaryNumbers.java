package com.leetcode.practice.queue;

import java.util.*;

// Given an integer N, generate all binary numbers from 1 to N and return them as a list of strings.

public class GenerateNBinaryNumbers {

    public static String[] generateBinaryNumbers(int n) {
        List<String> resultArray = new ArrayList<>();
        Queue<String> binQueue = new LinkedList<>();
        String element;
        // ToDo: Write Your Code Here.
        binQueue.add("1");
        while(resultArray.size() < n) {
            element = binQueue.poll();
            resultArray.add(element);
            binQueue.add(element + "0");
            binQueue.add(element + "1");
        }
        return Arrays.copyOf(resultArray.toArray(), resultArray.size(), String[].class);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateBinaryNumbers(4)));
    }

}
