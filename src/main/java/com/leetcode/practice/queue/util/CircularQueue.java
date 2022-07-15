package com.leetcode.practice.queue.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CircularQueue {
	
	static final Logger logger = LogManager.getLogger(CircularQueue.class);
	
	private int length = 0;
	private int[] queue;
	private int head = 0;
	private int tail = -1;
	
	public CircularQueue(int k) {
		queue = new int[k];
	}
	
	public boolean enQueue(int value) {
		if(isFull()) {
			return false;
		} else {
			if(tail == queue.length - 1) tail = -1;
			queue[++tail % queue.length] = value;
			length++;
			return true;
		}
	}
	
	public boolean deQueue() {
		if(isEmpty()) return false;
		else {
			if(head == queue.length - 1) {
				head = 0;
				length --;
				return true;
			}
			head++;
			length--;
			return true;
		}
	}
	
	public int Front() {
        if (isEmpty()){
            return -1;
        }
        return queue[head];
    }
    
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return queue[tail];
    }
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public boolean isFull() {
		return length == queue.length;
	}
	
	public void printQueue() {
		if(isEmpty()) {
			logger.info("Queue is empty.");
			return;
		}
		int pointer = 0;
		int temp = head;
		while(pointer < length) {
			int index = temp % (queue.length);
			logger.info("Element is: " + queue[index]);
			pointer++;
			temp++;
		}
	}

	public int getLength() {
		return length;
	}
	
	public int size() {
		return queue.length;
	}
	
	public int get(int index) {
		return queue[index];
	}

	public int getHead() {
		return head;
	}

	public int getTail() {
		return tail;
	}
}
