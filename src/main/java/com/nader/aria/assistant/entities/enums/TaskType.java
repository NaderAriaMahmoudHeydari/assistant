package com.nader.aria.assistant.entities.enums;

public enum TaskType {

	UN_PLANING(1),
	DAILY_SCHEDULE(2),
	SPRINT(3);
	
	private int no;
	
	public int getNo() { return no; }
	
	private TaskType(int no) { this.no = no; }
}
