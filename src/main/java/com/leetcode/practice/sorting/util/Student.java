package com.leetcode.practice.sorting.util;

public class Student {
	
	private String name;
	private int rollNo;
	private String regNo;
	
	public Student (String name) {
		this.name = name;
	}
	
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public Student(String name, int rollNo, String regNo) {
		this.name = name;
		this.rollNo = rollNo;
		this.regNo = regNo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
}
