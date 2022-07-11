package com.leetcode.practice.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.linkedlist.util.DoubleLinkedNode;

public class BasicDoubleLinkedList {
	
	static final Logger logger = LogManager.getLogger(BasicDoubleLinkedList.class);
	
	public static void createAndAppendSLL(int... elements) {
		logger.info("Creating LL.");
		DoubleLinkedNode node = new DoubleLinkedNode();
		for(int i=0; i<elements.length; i++) {
			node.appendElement(elements[i]);
		}
		node.appendElementAtBeginning(103);
		node.appendElementAtBeginning(105);
		node.addElementAtIndex(12204, 12);
		node.deleteAtBeginning();
		node.deleteAtBeginning();
		node.deleteAtEnd();
		node.deleteAtEnd();
		node.deleteAtIndex(8);
		node.displayNode();
		node.getElement(8);
		node.searchElement(17);
	}

	public static void main(String[] args) {
		BasicDoubleLinkedList.createAndAppendSLL(12, 13, 14, 15, 16, 17, 18, 90, 100, 101, 102);
	}

}
