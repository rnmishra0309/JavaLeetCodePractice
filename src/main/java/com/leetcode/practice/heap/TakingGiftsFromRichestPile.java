package com.leetcode.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You're presented with several piles of gifts, with each pile containing a certain number of gifts.
Every second, you'll engage in the following activity:

    1. Pick the pile that contains the highest number of gifts.
       If multiple piles share this distinction, you can select any of them.
    2. Compute the square root of the number of gifts in the selected pile,
       and then leave behind that many gifts (rounded down).
    3. Take all the other gifts from this pile.
    4. You'll do this for "k" seconds.

The objective is to find out how many gifts would still remain after these "k" seconds.

*/

public class TakingGiftsFromRichestPile {

    public static int remainingGifts(int[] gifts, int k) {
        int result = 0;
        int heapSize = gifts.length;
        int currentTime = 0;
        int newElement;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift: gifts) {
            maxHeap.add(gift);
        }
        while(currentTime < k) {
            newElement = (int) Math.floor(Math.sqrt(maxHeap.poll()));
            maxHeap.add(newElement);
            currentTime++;
        }
        while(!maxHeap.isEmpty()) result += maxHeap.poll();
        return result;
    }

}
