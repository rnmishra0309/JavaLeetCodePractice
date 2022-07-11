package com.leetcode.practice.linkedlist.util;

public interface LinkedListInterface {
	public void appendElement(int data);
	public void appendElementAtBeginning(int data);
	public void addElementAtIndex(int data, int index);
	public void deleteAtBeginning();
	public void deleteAtEnd();
	public void deleteAtIndex(int index);
	public void getElement(int index);
	public void searchElement(Integer element);
	public void displayNode();
}
