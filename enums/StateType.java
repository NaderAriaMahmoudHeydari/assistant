package com.nader.aria.assistant_blue.entities.enums;

public enum StateType {

	TODO(1),
	STORY(2),
	PLANED(3),
	OPENED(4),
	IN_PROGRESS(5),
	WAITING(6),
	DONE(7),
	CLOSED(8),
	REOPENED(9),
	MOVED(10),
	REPEATED(11);

	private int no; 
	
	public int getNo() { return no; }
	
	private StateType(int no) { this.no = no; }

}
