package com.leetcode.practice.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.queue.util.CircularQueue;

public class CircularQueuePractice {
	
	static final Logger logger = LogManager.getLogger(CircularQueuePractice.class);
	
	public static void circularQueue(CircularQueue queue, int... elements) {
		if(queue.isEmpty()) {
			logger.info("Queue is empty.");
			for(int index=0; index < elements.length; index++) {
				queue.enQueue(elements[index]);
			}
			queue.printQueue();
			queue.deQueue();
			queue.enQueue(4);
			queue.deQueue();
			queue.enQueue(5);
			queue.printQueue();
		}
	}

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(3);
		circularQueue(queue, 1,2,3);
	}

}
