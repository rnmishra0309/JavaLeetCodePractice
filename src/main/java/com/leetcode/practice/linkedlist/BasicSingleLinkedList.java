package com.leetcode.practice.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.leetcode.practice.linkedlist.util.SingleNode;

public class BasicSingleLinkedList {
	
	static final Logger logger = LogManager.getLogger(BasicSingleLinkedList.class);
	
	public static void createAndAppendSLL(int... elements) {
		logger.info("Creating LL.");
		SingleNode node = new SingleNode();
		for(int i=0; i<elements.length; i++) {
			node.appendElement(elements[i]);
		}
//		node.displayNode();
		node.appendElementAtBeginning(103);
		node.addElementAtIndex(12204, 12);
//		node.deleteAtBeginning();
//		node.deleteAtEnd();
//		node.deleteAtEnd();
		node.displayNode();
		logger.info("Before deletion");
		node.deleteAtIndex(5);
		node.displayNode();
		node.getElement(0);
		node.searchElement(14);
	}
	
	public static void testCase() {
		SingleNode node = new SingleNode();
		node.appendElementAtBeginning(7);
		node.appendElementAtBeginning(2);
		node.appendElementAtBeginning(1);
		node.addElementAtIndex(0,3);
		
		node.deleteAtIndex(2);
		
		node.appendElementAtBeginning(6);
		
		node.appendElement(4);
		node.displayNode();
		node.getElement(4);
		node.appendElementAtBeginning(4);
		node.addElementAtIndex(0, 5);
		node.appendElementAtBeginning(6);
	}
	
	public static void testDelete(int element) {
		SingleNode node = new SingleNode();
		node.appendElement(element);
		logger.info("Before deletion");
		node.displayNode();
		node.deleteAtEnd();
		logger.info("After deletion");
		node.displayNode();
	}
	
	public static void main(String[] args) {
		//BasicSingleLinkedList.createAndAppendSLL(12, 13, 14, 15, 16, 17, 18, 90, 100, 101, 102);
//		BasicSingleLinkedList.testDelete(12);
		BasicSingleLinkedList.testCase();
	}
}