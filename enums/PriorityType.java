package com.nader.aria.assistant_blue.entities.enums;

public enum PriorityType {
	
	CRITICAL(1),
	IMMEDIATE(2),
	HIGH(3),
	NORMAL(4),
	LOW(5);
	
	private int no;
	
	public int getNo() { return no; }
	
	private PriorityType(int no) { this.no = no; }

}
