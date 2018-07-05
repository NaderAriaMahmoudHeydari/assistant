package com.nader.aria.assistant.entities.enums;

public enum StateType {

	TODO(1),
	UN_PLANING(2),
	PLANED(3),
	OPENED(4),
	IN_PROGRESS(5),
	WAITING(6),
	DONE(7),
	CLOSED(8),
	REOPENED(9);
	
	
	private int no; 
	
	public int getNo() { return no; }
	
	private StateType(int no) { this.no = no; }
}
