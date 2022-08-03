package com.leetcode.practice.linkedlist.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleNode implements LinkedListInterface {
	
	static final Logger logger = LogManager.getLogger(SingleNode.class);
	
	public Node head;
	public Node tail;
	
	public class Node {
		public Integer data;
		public Node next;
		public Node down;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void appendElement(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void appendElementAtBeginning(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void addElementAtIndex(int data, int index) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else if(index == 0) {
			appendElementAtBeginning(data);
		} else {
			Node temp = head;
			int ind = 1;
			while(temp != null) {
				if(ind == index) {
					if(temp == tail) {
						appendElement(data);
						break;
					}
					newNode.next = temp.next;
					temp.next = newNode;
					break;
				}
				ind++;
				temp = temp.next;
			}
		}
	}
	
	public void deleteAtBeginning() {
		if(head == null) {
			logger.info("Nothing to delete as the LL is not present.");
		} else {
			Node temp = head;
			head = head.next;
			temp.next = null;
		}
	}
	
	public void deleteAtEnd() {
		if (head == null) {
			logger.info("Nothing to delete as the LL is not present.");
		} else {
			Node temp = head;
			if(temp.next != null) {
				while(temp.next.next != null) {
					temp = temp.next;
				}
				tail = temp;
				tail.next = null;
			} else {
				head = null;
				tail = null;
			}
		}
	}
	
	public void deleteAtIndex(int index) {
		if (head == null) {
			logger.info("Nothing to delete as the LL is not present.");
		} else if(index == 0) {
			deleteAtBeginning();
		} else {
			Node temp = head;
			Node nextNode = null;
			int ind = 1;
			while(temp.next != null) {
				if(ind == index) {
					nextNode = temp.next;
					temp.next = nextNode.next;
					nextNode.next = null;
					break;
				}
				temp = temp.next;
				ind++;
			}
		}
	}
	
	public void getElement(int index) {
		if (head == null) {
			logger.info("The LL is not present.");
		} else {
			int ind = 0;
			Node temp = head;
			while(temp != null) {
				if(ind == index) {
					logger.info("The element found is: " + temp.data.toString());
					ind = -1;
					break;
				}
				temp = temp.next;
				ind++;
			}
			if(ind != -1) {
				logger.info("No element was found with the index.");
			}
		}
	}
	
	public void searchElement(Integer element) {
		if (head == null) {
			logger.info("The LL is not present.");
		} else {
			int ind = 0;
			Node temp = head;
			while(temp != null) {
				if(temp.data == element) {
					logger.info("The element found is: " + temp.data.toString() + " at index: " + ind);
					ind = -1;
					break;
				}
				temp = temp.next;
				ind++;
			}
			if(ind != -1) {
				logger.info("No element was found with the given number.");
			}
		}
	}
	
	public void displayNode() {
		if(head == null) {
			logger.info("The List is Empty.");
		} else {
			Node pointer = head;
			logger.info("Head: " + head.data.toString());
			logger.info("Tail: " + tail.data.toString());
			while(pointer != null) {
				logger.info("Element is: " + pointer.data.toString());
				pointer = pointer.next;
			}
		}
	}
}
