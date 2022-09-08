package com.leetcode.practice.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leetcode.practice.linkedlist.util.Node;

/**
 * Given a singly linked list with two nodes next and down, print level order.
 * 
 * Example: 
 * 
 * 1 -> 2 -> 3 -> 4 -> 5
 * |              |
 * 6 -> 7 -> 8    9 -> 10
 *      |    |    |
 *      11   12   13 -> 14
 *           |    |
 *           15   16 -> 17
 *           
 * Output: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17
 * 
 * 
 * @author RudraNM
 *
 */
public class FlattenMultilevelSinglyLinkedList {
	
	static final Logger logger = LogManager.getLogger(FlattenMultilevelSinglyLinkedList.class);
	
	public static Node flattenSinglyLinkedList(Node head) {
		if(head == null) return null;
		Node cur = head;
		Queue<Node> queue = new LinkedList<Node>();
		while(cur.next != null && !queue.isEmpty()) {
			if(cur.down != null) {
				queue.offer(cur.down);
				cur.down = null;
				cur = cur.next;
				continue;
			}
			if(cur.next == null) {
				Node next = queue.poll();
				cur.next = next;
			}
			cur = cur.next;
		}
		return head;
	}
	
	public static void printNode(Node head) {
		Node cur = head;
		while(cur != null) {
			logger.info(cur.data.toString() + " -> ");
		}
		return;
	}
	
	public static void main(String[] args) {
		
	}
}
