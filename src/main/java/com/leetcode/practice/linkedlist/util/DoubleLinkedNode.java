package com.leetcode.practice.linkedlist.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoubleLinkedNode implements LinkedListInterface {
	
	static final Logger logger = LogManager.getLogger(DoubleLinkedNode.class);
	
	public Node head;
	public Node tail;
	
	public class Node {
		public Integer data;
		public Node next;
		public Node prev;
		public Node child;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public DoubleLinkedNode() {
		head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
	}

	public void appendElement(int data) {
		Node n = new Node(data);
        n.next = tail;
        n.prev = tail.prev;
        tail.prev = n;
        n.prev.next = n;
	}

	public void appendElementAtBeginning(int data) {
		Node n = new Node(data);
        n.next = head.next;
        n.prev = head;
        head.next = n;
        n.next.prev = n;
	}

	public void addElementAtIndex(int data, int index) {
		int i = 0;
        Node p = head;
        for(; i < index && p.next != tail; i++) {
            p = p.next;
        }

        if(i != index)
            return;

        Node n = new Node(data);
        n.prev = p;
        n.next = p.next;
        p.next = n;
        n.next.prev = n;
	}

	public void deleteAtBeginning() {
		if(head == null) {
			logger.info("There is no DLL to begin with.");
		} else if(head.next == null) {
			head = null;
			tail = null;
		} else {
			Node temp = head.next;
			temp.prev = null;
			head.next = null;
			head = temp;
		}
	}

	public void deleteAtEnd() {
		if(head == null) {
			logger.info("There is no DLL to begin with.");
		} else if(head.next == null) {
			head = null;
			tail = null;
		} else {
			Node temp = tail.prev;
			tail.prev = null;
			temp.next = null;
			tail = temp;
		}
	}

	public void deleteAtIndex(int index) {
		int i = 0;
        Node p = head;
        for(; i < index && p.next != tail; i++) {
            p = p.next;
        }

        if(p.next == tail)
            return;

        p.next = p.next.next;
        p.next.prev = p;
	}

	public void getElement(int index) {
		if(head == null) {
			logger.info("There is no DLL to begin with.");
		} else {
			if(index < 0)
	            logger.info("Invalid Index.");

	        int i = 0;
	        Node p = head;
	        for(; i < index && p.next != tail; i++) {
	            p = p.next;
	        }

	        logger.info("Element is: " + p.next.data.toString());
		}
	}

	public void searchElement(Integer element) {
		if(head == null) {
			logger.info("There is no DLL to begin with.");
		} else {
			int ind = 0;
			Node temp = head;
			while(temp != null) {
				if(temp.data == element) {
					logger.info("Element is at: " + ind + " value is: " + temp.data.toString());
					ind = -1;
					break;
				}
				ind++;
				temp = temp.next;
			}
			if(ind != -1) { 
				logger.info("Element not found.");
			}
		}
	}

	public void displayNode() {
		if(head == null) {
			logger.info("No Double LL Found.");
		} else {
			Node temp = head;
			while(temp != null) {
				logger.info("Element is: " + temp.data.toString());
				temp = temp.next;
			}
		}
	}
	
}
