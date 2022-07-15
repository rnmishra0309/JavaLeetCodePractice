package com.leetcode.practice.queue.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinearQueue {
	
	static final Logger logger = LogManager.getLogger(LinearQueue.class);
	
	// store the list
	private List<Integer> queue;
	private int head;
	
	// Initialise the queue.
	public LinearQueue() {
		queue = new ArrayList<Integer>();
		head = 0;
	}
	
	// Enqueue operation
	public boolean enQueue(int value) {
		try {
			this.queue.add(value);
			return true;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return false;
		}
	}
	
	// Dequeue operation
	public boolean deQueue() {
		try {
			if(isEmpty()) {
				logger.info("Queue is empty. No dequeue operation can be done.");
				return false;
			}
			head++;
			return true;
		} catch(Exception e) {
			logger.info(e.getMessage());
			return false;
		}
	}
	
	// checks if the queue is empty or not
	public boolean isEmpty() {
		return head >= queue.size();
	}
	
	public void printQueue() {
		if(isEmpty()) {
			logger.info("Queue is empty.");
			return;
		}
		int pointer = head;
		while(pointer != queue.size()) {
			logger.info("Element is: " + queue.get(pointer++).toString());
		}
	}
	
	// get the front element of the queue
	public int front() {
		return queue.get(head);
	}
}
