package com.leetcode.practice.queue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.queue.util.CircularQueue;

public class MovingAverageOfDataStream {
	
	static final Logger logger = LogManager.getLogger(MovingAverageOfDataStream.class);
	
	// My Solution -  O(N^2)
	public static double findAverage(CircularQueue queue) {
		double sum = 0;
		int pointer = queue.getHead();
		int count = 0;
		while(count < queue.getLength()) {
			sum += queue.get(pointer % queue.size());
			pointer++;
			count++;
		}
		sum /= queue.getLength();
		return sum;
	}
	
	public static void findMovingAverage(CircularQueue queue, int... elements) {
		for(int i = 0; i < elements.length; i++) {
			if(queue.isFull()) queue.deQueue();
			queue.enQueue(elements[i]);
			double avg = findAverage(queue);
			logger.info("Average is: " + avg);
		}
	}
	
	// more efficient solution using DeQueue
	class MovingAverage {
	    int k,sum;
	    Deque<Integer> q = new ArrayDeque<Integer>();
	    public MovingAverage(int size) {
	        this.k = size;
	        this.sum = 0;
	    }
	    public double next(int val) {
	        q.add(val);
	        sum += val;
	        int curr_size = q.size();
	        if(curr_size>k){
	            curr_size = curr_size - 1;
	            sum = sum - (Integer)q.poll();
	        }
	        return (sum*1.0)/curr_size;
	    }
	}
	
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(3);
		findMovingAverage(queue, 1,10,5,4);
		
	}
}
