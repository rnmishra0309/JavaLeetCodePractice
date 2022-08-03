package com.leetcode.practice.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.queue.util.LinearQueue;

public class LinearQueueMain {

	
	static final Logger logger = LogManager.getLogger(LinearQueueMain.class);
	
	public static void linearQueuePractice(LinearQueue queue, int... elements) {
		if(queue.isEmpty()) {
			logger.info("Queue is empty.");
			for(int index=0; index < elements.length; index++) {
				queue.enQueue(elements[index]);
			}
			queue.printQueue();
			queue.deQueue();
			queue.deQueue();
			queue.deQueue();
			queue.printQueue();
		}
	}
	
	public static void main(String[] args) {
		LinearQueue queue = new LinearQueue();
		linearQueuePractice(queue, 1,2,3);
	}
}
