package com.leetcode.practice.linkedlist.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoubleLinkedNode implements LinkedListInterface {
	
	static final Logger logger = LogManager.getLogger(DoubleLinkedNode.class);
	
	public Node head;
	public Node tail;
	
	class Node {
		Integer data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public void appendElement(int data) {
		if(head == null) {
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		} else {
			Node temp = new Node(data);
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}

	public void appendElementAtBeginning(int data) {
		if(head == null) {
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		} else {
			Node temp = new Node(data);
			head.prev = temp;
			temp.next = head;
			head = temp;
		}
	}

	public void addElementAtIndex(int data, int index) {
		if(head == null) {
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		} else if(index == 0) {
			appendElementAtBeginning(data);
		} else {
			Node newNode = new Node(data);
			int ind = 1;
			Node temp = head;
			while(temp.next != null) {
				if(ind == index) {
					temp.next.prev = newNode;
					newNode.next = temp.next;
					newNode.prev = temp;
					temp.next = newNode;
				}
				ind++;
				temp = temp.next;
			}
		}
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
		if(head == null) {
			logger.info("There is no DLL to begin with.");
		} else if(index == 0) {
			deleteAtBeginning();
		}else {
			int ind = 0;
			Node temp = head;
			while(temp.next != null) {
				if(ind == index) {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					temp.next = null;
					temp.prev = null;
					break;
				}
				ind++;
				temp = temp.next;
			}
		}
	}

	public void getElement(int index) {
		if(head == null) {
			logger.info("There is no DLL to begin with.");
		} else {
			int ind = 0;
			Node temp = head;
			while(temp != null) {
				if(ind == index) {
					logger.info("Element is at: " + ind + " value is: " + temp.data.toString());
					ind = -1;
					break;
				}
				ind++;
				temp = temp.next;
			}
			if(ind != -1) { 
				logger.info("Index not found.");
			}
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
